package org.example.config.thread;
 

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.example.entity.SeckillOrderInfo;
import org.example.entity.convert.SeckillGoodsConvert;
import org.example.entity.vo.SeckillGoodsVo;
import org.example.mapper.CommodityMapper;
import org.example.mapper.SeckillGoodsMapper;
import org.example.mapper.SeckillOrderMapper;
import org.example.model.R;
import org.example.util.RedisCache;
import org.example.util.UserThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
 
public class CreateSeckillOrder implements Runnable {

    @Autowired
    SeckillGoodsMapper seckillGoodsMapper;
    @Autowired
    SeckillOrderMapper seckillOrderMapper;
    @Autowired
    CommodityMapper commodityMapper;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public void run() {
        Map<String,Object> param = (Map<String, Object>) redisTemplate.boundListOps("seckill_order").rightPop();
    }
}