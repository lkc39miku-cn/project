package org.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.entity.SeckillGoods;
import org.example.entity.param.SeckillGoodsParam;
import org.example.entity.vo.SeckillGoodsVo;
import org.example.model.R;

import java.util.List;

/**
* @author adm
* @description 针对表【seckill_goods(秒杀商品表)】的数据库操作Service
* @createDate 2022-08-30 10:18:34
*/
public interface SeckillGoodsService  {
List<SeckillGoodsVo> selAll();
IPage<SeckillGoods> selectListByPage();
SeckillGoodsVo findSeckillGoods(SeckillGoodsParam seckillGoodsParam);
 R<String> saveSeckillOrder(SeckillGoodsParam seckillGoodsParam);

 }
