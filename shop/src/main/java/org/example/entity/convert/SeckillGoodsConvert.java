package org.example.entity.convert;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.entity.Commodity;
import org.example.entity.OrderInfo;
import org.example.entity.SeckillGoods;
import org.example.entity.vo.OrderInfoVo;
import org.example.entity.vo.SeckillGoodsVo;
import org.example.mapper.CommodityMapper;
import org.example.util.Convert;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class SeckillGoodsConvert implements Convert<SeckillGoods, SeckillGoodsVo> {
@Autowired
    CommodityMapper commodityMapper;
    @Override
    public abstract SeckillGoodsVo convert(SeckillGoods seckillGoods);

    @Override
    public abstract List<SeckillGoodsVo> convert(List<SeckillGoods> seckillGoods);



    @AfterMapping
    public void convert(SeckillGoods seckillGoods, @MappingTarget SeckillGoodsVo seckillGoodsVo) {
        seckillGoodsVo.setCommodity(commodityMapper.selectOne(new LambdaQueryWrapper<Commodity>()
                .eq(Commodity::getId, seckillGoodsVo.getGoodsId())));
    }

    @AfterMapping
    public void convert(List<SeckillGoods> seckillGoods, @MappingTarget List<SeckillGoodsVo> seckillGoodsVoList) {
        seckillGoodsVoList.forEach(v -> convert(null, v));
    }


}
