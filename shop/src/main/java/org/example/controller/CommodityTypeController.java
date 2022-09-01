package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.entity.CommodityType;
import org.example.entity.convert.CommodityTypeConvert;
import org.example.entity.vo.CommodityTypeVo;
import org.example.model.R;
import org.example.service.CommodityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "类型")
@RestController
@RequestMapping(value = "/commodity/type")
public class CommodityTypeController {
    @Autowired
    private CommodityTypeService commodityTypeService;
    @Autowired
    private CommodityTypeConvert commodityTypeConvert;

    @ApiOperation(value = "类型查询")
    @GetMapping("/select")
    private R<List<CommodityTypeVo>> select(){
        return new R<List<CommodityTypeVo>>()
                .ok(commodityTypeConvert.convert(commodityTypeService.select()));
    }
}
