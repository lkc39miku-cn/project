package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.entity.Menu;
import org.example.entity.vo.MenuVo;
import org.example.key.MenuKey;
import org.example.service.CommodityTypeService;
import org.example.entity.CommodityType;
import org.example.entity.convert.CommodityTypeConvert;
import org.example.entity.vo.CommodityTypeVo;
import org.example.key.CommodityTypeKey;
import org.example.model.R;
import org.example.result.CompareExecute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品类型")
@RestController
@RequestMapping(value = "/commodity/type")
public class CommodityTypeController {
    @Autowired
    private CommodityTypeService commodityTypeService;
    @Autowired
    private CommodityTypeConvert commodityTypeConvert;

    @ApiOperation(value = "查询商品类型")
    @GetMapping(value = "/tree")
    public R<List<CommodityTypeVo>> tree() {
        return new R<List<CommodityTypeVo>>().ok(commodityTypeService.selectList());
    }

    @ApiOperation(value = "新增商品类型")
    @PostMapping("/insert")
    public R<String> insert(@RequestBody CommodityType commodityType) {
        return new CompareExecute<>().compare(commodityTypeService.insert(commodityType), CompareExecute.ExecuteStatus.INSERT);
    }

    @ApiOperation(value = "修改商品类型")
    @PutMapping("/update")
    public R<String> update(@RequestBody CommodityType commodityType) {
        return new CompareExecute<>().compare(commodityTypeService.update(commodityType), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "删除商品类型")
    @DeleteMapping("/delete/{id}")
    public R<String> delete(@PathVariable("id") String id) {
            return new CompareExecute<>().compare(commodityTypeService.delete(id), CompareExecute.ExecuteStatus.DELETE);
    }

    @ApiOperation(value = "修改商品类型显示")
    @PostMapping(value = "/publish/status/on")
    public R<String> publishStatusOn(String id) {
        return new CompareExecute<>().compare(commodityTypeService.update(
                (CommodityType) new CommodityType()
                        .setPublishStatus(CommodityTypeKey.PUBLISH_STATUS_ON)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "修改商品类型隐藏")
    @PostMapping(value = "/publish/status/off")
    public R<String> publishStatusOff(String id) {
        return new CompareExecute<>().compare(commodityTypeService.update(
                (CommodityType) new CommodityType()
                        .setPublishStatus(CommodityTypeKey.PUBLISH_STATUS_OFF)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }
}
