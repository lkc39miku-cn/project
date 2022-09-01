package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.entity.convert.SeckillGoodsConvert;
import org.example.entity.vo.SeckillGoodsVo;
import org.example.model.R;
import org.example.service.SeckillGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seckill")
@Api(tags = "秒杀管理")
public class SeckillController {
    @Autowired
    private SeckillGoodsService seckillGoodsService;
    @Autowired
    private SeckillGoodsConvert seckillGoodsConvert;

    @GetMapping("/findAllSeckillGoods")
    @ApiOperation(value = "查询所有秒杀商品", notes = "查询所有秒杀商品")
    public R<List<SeckillGoodsVo>> selectList() {
        List<SeckillGoodsVo> seckillGoodsList = seckillGoodsService.selAll();
        return new R<List<SeckillGoodsVo>>().ok(seckillGoodsList);
    }

}
