package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.entity.convert.StoreHouseConvert;
import org.example.entity.vo.CommodityBrandVo;
import org.example.entity.vo.StoreHouseInVo;
import org.example.entity.vo.StoreHouseVo;
import org.example.model.R;
import org.example.service.StoreHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "仓库")
@RestController
@RequestMapping(value = "/store/house")
public class StoreHouseController {
    @Autowired
    private StoreHouseService storeHouseService;
    @Autowired
    private StoreHouseConvert storeHouseConvert;

    @ApiOperation(value = "仓库查询")
    @GetMapping(value = "/select")
    public R<List<StoreHouseVo>> select(){
        return  new R<List<StoreHouseVo>>()
                .ok(storeHouseConvert.convert(storeHouseService.select()));
    }
}
