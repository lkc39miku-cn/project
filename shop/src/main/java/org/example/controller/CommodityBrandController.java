package org.example.controller;

import io.swagger.annotations.Api;
import org.example.service.CommodityBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "商品品牌")
@RestController
@RequestMapping(value = "/commodity/brand")
public class CommodityBrandController {
    @Autowired
    private CommodityBrandService commodityBrandService;
}
