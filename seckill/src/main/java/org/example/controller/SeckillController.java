package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.entity.convert.SeckillGoodsConvert;
import org.example.entity.param.SeckillGoodsParam;
import org.example.entity.vo.SeckillGoodsVo;
import org.example.model.R;
import org.example.service.SeckillGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/findSeckillGoodsById")
    @ApiOperation(value = "根据查询所有秒杀商品详情", notes = "根据查询所有秒杀商品详情")
    public R<SeckillGoodsVo> findById(SeckillGoodsParam seckillGoodsParam) {
        SeckillGoodsVo seckillGoodsList = seckillGoodsService.findSeckillGoods(seckillGoodsParam);
        return new R<SeckillGoodsVo>().ok(seckillGoodsList);
    }

    @PostMapping("/saveSeckillOrder")
    @ApiOperation(value = "保存订单", notes = "保存订单")
    public R<String> saveSeckillOrder(SeckillGoodsParam seckillGoodsParam) {
        return seckillGoodsService.saveSeckillOrder(seckillGoodsParam);
    }

    //    @GetMapping(value = "/pay")
//    @ApiOperation(value = "支付",notes = "支付")
//    public void pay(HttpServletRequest request)  {
//        seckillGoodsService.pay(request);
//    }
    @PostMapping("/addSeckillGoods")
    @ApiOperation(value = "添加秒杀商品", notes = "添加秒杀商品")
    public R<String> addSeckillGoods(SeckillGoodsParam seckillGoodsParam) {
        return seckillGoodsService.addSeckillGoods(seckillGoodsParam);
    }
    @PostMapping("/updateAllStatus")
    @ApiOperation(value = "终止所有秒杀活动", notes = "终止所有秒杀活动")
    public R<String> updateAllStatus(SeckillGoodsParam seckillGoodsParam) {
        return seckillGoodsService.updateAllStatus();
    }

}
