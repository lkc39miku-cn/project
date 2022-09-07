package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Commodity;
import org.example.entity.SeckillGoods;
import org.example.entity.SeckillOrderInfo;
import org.example.entity.convert.SeckillGoodsConvert;
import org.example.entity.param.SeckillGoodsParam;
import org.example.entity.vo.SeckillGoodsVo;
import org.example.mapper.CommodityMapper;
import org.example.mapper.SeckillOrderMapper;
import org.example.model.R;
import org.example.service.SeckillGoodsService;
import org.example.mapper.SeckillGoodsMapper;
import org.example.util.PageUtil;
import org.example.util.RedisCache;
import org.example.util.UserThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author adm
* @description 针对表【seckill_goods(秒杀商品表)】的数据库操作Service实现
* @createDate 2022-08-30 10:18:34
*/
@Service
@Slf4j
public class SeckillGoodsServiceImpl implements SeckillGoodsService{
    @Autowired
    SeckillGoodsMapper seckillGoodsMapper;
    @Autowired
    SeckillGoodsConvert seckillGoodsConvert;
    @Autowired
    SeckillOrderMapper seckillOrderMapper;
    @Autowired
    CommodityMapper commodityMapper;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<SeckillGoodsVo> selAll() {
        return redisTemplate.boundHashOps("seckill_goods_all").values();
    }

    @Override
    public IPage<SeckillGoods> selectListByPage() {
        return seckillGoodsMapper.selectPage(new Page<>(PageUtil.page(), PageUtil.pageSize()), null);
    }

    @Override
    public SeckillGoodsVo findSeckillGoods(SeckillGoodsParam seckillGoodsParam) {

        return (SeckillGoodsVo) redisCache.getCacheMap("seckill_goods_all").get(seckillGoodsParam.getGoodsId());
    }

    @Override
    public R<String> saveSeckillOrder(SeckillGoodsParam seckillGoodsParam) {
        SeckillGoodsVo seckillGoodsVo=getSeckillGoodsVO(seckillGoodsParam);
        String userId=UserThreadLocal.getUser().getId();
//        Boolean b=redisTemplate.boundHashOps("seckill_order"+userId).
            if (seckillGoodsVo==null){
                return new R<String>().fail("商品已终止销售");
            } else {
                SeckillOrderInfo seckillOrder = new SeckillOrderInfo();
                //seckill_id bigint(20) NULL秒杀商品ID
                seckillOrder.setSeckillCommodityId(seckillGoodsParam.getGoodsId());
                //money decimal(10,2) NULL支付金额
                seckillOrder.setMoney(seckillGoodsVo.getSeckillPrice());
                //user_id varchar(50) NULL用户
                seckillOrder.setUserId(userId);
                //create_time datetime NULL创建时间
                seckillOrder.setCreateTime(LocalDateTime.now());
                //保存秒杀订单到mysql数据库中
                seckillOrderMapper.insert(seckillOrder);
                //订单保存成功,则秒杀商品在redis数据库中的库存-1
                seckillGoodsVo.setSeckillCount(seckillGoodsVo.getSeckillCount()-1);
                //如果库存为0,则删除redis数据库中的秒杀商品数据,停止售卖
                if(seckillGoodsVo.getSeckillCount()==0) {
                    //售完后在更新mysql数据库
                    seckillGoodsMapper.updateById(seckillGoodsVo);
                }else {
                    //如果数量不为0则把商品保存回redis中
                    Map<String,Object> map=new HashMap<>();
                    map.put(seckillGoodsParam.getGoodsId(),seckillGoodsVo);
                    redisCache.setCacheMap("seckill_goods_all",map);
                }

                //保存待支付的订单到redis数据库中,为了支付时修改
                Map<String,Object> map=new HashMap<>();
                map.put(userId,seckillOrder);
                redisCache.setCacheMap("seckill_order",map);
            }
        return new R<String>().ok();
    }

//    @Override
//    public void pay(HttpServletRequest request) throws AlipayApiException {
//
//    }

    @Override
    public R<String> addSeckillGoods(SeckillGoodsParam seckillGoodsParam) {
        SeckillGoods seckillGoods=new SeckillGoods();
        seckillGoods.setGoodsId(seckillGoodsParam.getGoodsId());
        seckillGoods.setSeckillStatus(0);
        seckillGoods.setSeckillCount(seckillGoodsParam.getSeckillCount());
        seckillGoods.setStartDate(seckillGoodsParam.getStartDate());
        seckillGoods.setEndDate(seckillGoodsParam.getEndDate());
        seckillGoods.setCreateTime(LocalDateTime.now());
        seckillGoods.setUpdateTime(LocalDateTime.now());
        if (seckillGoodsMapper.insert(seckillGoods)>0){
            return new R<String>().ok() ;
        }else {
            return new R<String>().fail("添加失败");
        }
    }

    @Override
    public R<String> updateAllStatus() {

       Integer c=  seckillGoodsMapper.update(null, new LambdaUpdateWrapper<SeckillGoods>().set(SeckillGoods::getSeckillStatus, 0));
       if (c>0){
           return  new R<String>().ok();
       }else {
           return new R<String>().fail("终止失败");

       }
    }

    private SeckillGoodsVo getSeckillGoodsVO(SeckillGoodsParam seckillGoodsParam){
        return (SeckillGoodsVo) redisCache.getCacheMap("seckill_goods_y").get(seckillGoodsParam.getGoodsId());
    }


}




