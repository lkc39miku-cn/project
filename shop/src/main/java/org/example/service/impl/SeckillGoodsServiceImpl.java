package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.SeckillGoods;
import org.example.entity.convert.SeckillGoodsConvert;
import org.example.entity.param.SeckillGoodsParam;
import org.example.entity.vo.SeckillGoodsVo;
import org.example.service.SeckillGoodsService;
import org.example.mapper.SeckillGoodsMapper;
import org.example.util.PageUtil;
import org.example.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author adm
* @description 针对表【seckill_goods(秒杀商品表)】的数据库操作Service实现
* @createDate 2022-08-30 10:18:34
*/
@Service
public class SeckillGoodsServiceImpl implements SeckillGoodsService{
    @Autowired
    SeckillGoodsMapper seckillGoodsMapper;
    @Autowired
    SeckillGoodsConvert seckillGoodsConvert;
    @Autowired
    private RedisCache redisCache;

    @Override
    public List<SeckillGoodsVo> selAll() {
        List<SeckillGoodsVo>  seckillGoodsList=  redisCache.getCacheList("seckill_goods_all");
        return seckillGoodsList;
    }

    @Override
    public IPage<SeckillGoods> selectListByPage() {
        return seckillGoodsMapper.selectPage(new Page<>(PageUtil.page(), PageUtil.pageSize()), null);
    }

    @Override
    public SeckillGoodsVo findSeckillGoods(SeckillGoodsParam seckillGoodsParam) {
        List<SeckillGoodsVo>  seckillGoodsList=  redisCache.getCacheList("seckill_goods_all");
        SeckillGoodsVo seckillGoodsVo=null;
        for (SeckillGoodsVo s : seckillGoodsList) {
            if (s.getGoodsId().equals(seckillGoodsParam.getGoodsId()) ){
                seckillGoodsVo=s;
                return seckillGoodsVo;
            }
        }
        return seckillGoodsVo;
    }

}




