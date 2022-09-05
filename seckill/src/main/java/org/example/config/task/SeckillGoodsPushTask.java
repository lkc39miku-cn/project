package org.example.config.task;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.entity.SeckillGoods;
import org.example.entity.convert.SeckillGoodsConvert;
import org.example.mapper.SeckillGoodsMapper;
import org.example.service.SeckillGoodsService;
import org.example.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SeckillGoodsPushTask {
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private SeckillGoodsMapper seckillGoodsMapper;
    @Autowired
    private SeckillGoodsService seckillGoodsService;
    @Autowired
    private SeckillGoodsConvert seckillGoodsConvert;
    @Autowired
    private RedisTemplate redisTemplate;

    @Scheduled(cron = "0/1 * * * * ?")
    public void loadGoodsStatus() {
        LambdaQueryWrapper<SeckillGoods> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .gt(SeckillGoods::getSeckillCount, 0)
                .ge(SeckillGoods::getStartDate, new Date())
                .lt(SeckillGoods::getEndDate, new Date());
        SeckillGoods seckillGoods = new SeckillGoods();
        seckillGoods.setSeckillStatus(1);
        if (!seckillGoodsMapper.selectList(null).isEmpty()) {
            seckillGoodsMapper.update(seckillGoods, queryWrapper);
        }
    }

    @Scheduled(cron = "0/1 * * * * ?")
    public void loadSeckillGoodsToRedis() {
        LambdaQueryWrapper<SeckillGoods> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .gt(SeckillGoods::getSeckillCount, 0)
                .eq(SeckillGoods::getSeckillStatus, 1)
                .ge(SeckillGoods::getStartDate, new Date())
                .lt(SeckillGoods::getEndDate, new Date());
        List<SeckillGoods> seckillGoodsList = seckillGoodsMapper.selectList(queryWrapper);
        if (!seckillGoodsList.isEmpty()) {
            for (SeckillGoods seckillGoods : seckillGoodsList) {
                Map<String, Object> map = new HashMap<>();
                map.put(seckillGoods.getGoodsId(), seckillGoodsConvert.convert(seckillGoods));
                redisCache.setCacheMap("seckill_goods_y", map);
            }
        }
//    redisCache.delCacheMapValue("seckill_goods","");
    }

    @Scheduled(cron = "0/120 * * * * ?")
    public void loadSeckillGoodsAllTORedis() {
        List<SeckillGoods> seckillGoodsList = seckillGoodsMapper.selectList(null);
        if (!seckillGoodsList.isEmpty()) {
            for (SeckillGoods seckillGoods : seckillGoodsList) {
                Map<String, Object> map = new HashMap<>();
                map.put(seckillGoods.getGoodsId(), seckillGoodsConvert.convert(seckillGoods));
                redisCache.setCacheMap("seckill_goods_all", map);
            }
        }
    }
        @Scheduled(cron = "0/119 * * * * ?")
        public void updateSeckillGoods () {
           Map<String,Object> map= redisTemplate.opsForHash().entries("seckill_goods_all");
           for(Map.Entry<String,Object> entry:map.entrySet()) {
               SeckillGoods seckillGoods= (SeckillGoods) entry.getValue();
               seckillGoodsMapper.updateById(seckillGoods);
           }
        }


}

