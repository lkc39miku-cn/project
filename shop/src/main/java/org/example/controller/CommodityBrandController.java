package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.entity.convert.CommodityBrandConvert;
import org.example.entity.vo.CommodityBrandVo;
import org.example.model.R;
import org.example.service.CommodityBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "商品品牌")
@RestController
@RequestMapping(value = "/commodity/brand")
public class CommodityBrandController {
    @Autowired
    private CommodityBrandService commodityBrandService;
    @Autowired
    private CommodityBrandConvert commodityBrandConvert;

    @ApiOperation(value = "查询所有数据")
    @GetMapping(value = "/select")
    public R<List<CommodityBrandVo>> select() {
        return new R<List<CommodityBrandVo>>()
                .ok(commodityBrandConvert.convert(commodityBrandService.select()));
    }

}
