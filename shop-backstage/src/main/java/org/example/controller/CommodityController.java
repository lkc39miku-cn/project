package org.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.CommodityService;
import org.example.entity.Commodity;
import org.example.entity.convert.CommodityConvert;
import org.example.entity.param.CommodityParam;
import org.example.entity.vo.CommodityVo;
import org.example.key.CommodityKey;
import org.example.model.PageR;
import org.example.model.R;
import org.example.result.CompareExecute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品")
@RestController
@RequestMapping(value = "/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;
    @Autowired
    private CommodityConvert commodityConvert;

    @ApiOperation(value = "查询商品")
    @GetMapping(value = "/select")
    public PageR<List<CommodityVo>> select(CommodityParam commodityParam) {
        IPage<Commodity> iPage = commodityService.selectListByPage(commodityParam);
        return new PageR<List<CommodityVo>>().ok(commodityConvert.convert(iPage.getRecords()))
                .setCount(iPage.getTotal());
    }

    @ApiOperation(value = "新增商品")
    @PostMapping("/insert")
    public R<String> insert(@RequestBody Commodity commodity) {
        return new CompareExecute<>().compare(commodityService.insert(commodity), CompareExecute.ExecuteStatus.INSERT);
    }

    @ApiOperation(value = "修改商品")
    @PutMapping("/update")
    public R<String> update(@RequestBody Commodity commodity) {
        return new CompareExecute<>().compare(commodityService.update(commodity), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "删除商品")
    @DeleteMapping("/delete/{id}")
    public R<String> delete(@PathVariable("id") String id) {
        return new CompareExecute<>().compare(commodityService.delete(id), CompareExecute.ExecuteStatus.DELETE);
    }

    @ApiOperation(value = "修改商品上架")
    @PostMapping(value = "/publish/status/on")
    public R<String> publishStatusOn(String id) {
        return new CompareExecute<>().compare(commodityService.update(
                (Commodity) new Commodity()
                        .setPublishStatus(CommodityKey.PUBLISH_STATUS_ON)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "修改商品下架")
    @PostMapping(value = "/publish/status/off")
    public R<String> publishStatusOff(String id) {
        return new CompareExecute<>().compare(commodityService.update(
                (Commodity) new Commodity()
                        .setPublishStatus(CommodityKey.PUBLISH_STATUS_OFF)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "修改商品删除")
    @PostMapping(value = "/delete/status/on")
    public R<String> deleteStatusOn(String id) {
        return new CompareExecute<>().compare(commodityService.update(
                (Commodity) new Commodity()
                        .setDeleteStatus(CommodityKey.DELETE_STATUS_ON)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "修改商品 not 删除")
    @PostMapping(value = "/delete/status/off")
    public R<String> deleteStatusOff(String id) {
        return new CompareExecute<>().compare(commodityService.update(
                (Commodity) new Commodity()
                        .setDeleteStatus(CommodityKey.DELETE_STATUS_OFF)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }
}
