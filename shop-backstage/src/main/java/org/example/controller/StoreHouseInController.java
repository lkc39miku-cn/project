package org.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.service.StoreHouseInService;
import org.example.entity.StoreHouseIn;
import org.example.entity.convert.StoreHouseInConvert;
import org.example.entity.param.StoreHouseInParam;
import org.example.entity.vo.StoreHouseInVo;
import org.example.key.StoreHouseInKey;
import org.example.model.PageR;
import org.example.model.R;
import org.example.result.CompareExecute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "库存入库")
@RestController
@RequestMapping(value = "/store/house/in")
public class StoreHouseInController {
    @Autowired
    private StoreHouseInService storeHouseInService;
    @Autowired
    private StoreHouseInConvert storeHouseInConvert;

    @ApiOperation(value = "查询库存入库")
    @GetMapping(value = "/select")
    public PageR<List<StoreHouseInVo>> select(StoreHouseInParam storeHouseInParam) {
        IPage<StoreHouseIn> iPage = storeHouseInService.selectListByPage(storeHouseInParam);
        return new PageR<List<StoreHouseInVo>>().ok(storeHouseInConvert.convert(iPage.getRecords()))
                .setCount(iPage.getTotal());
    }

    @ApiOperation(value = "新增库存入库")
    @PostMapping("/insert")
    public R<String> insert(@RequestBody StoreHouseIn storeHouseIn) {
        return new CompareExecute<>().compare(storeHouseInService.insert(storeHouseIn), CompareExecute.ExecuteStatus.INSERT);
    }

    @ApiOperation(value = "修改库存入库")
    @PutMapping("/update")
    public R<String> update(@RequestBody StoreHouseIn storeHouseIn) {
        return new CompareExecute<>().compare(storeHouseInService.update(storeHouseIn), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "删除库存入库")
    @DeleteMapping("/delete/{id}")
    public R<String> delete(@PathVariable("id") String id) {
        return new CompareExecute<>().compare(storeHouseInService.delete(id), CompareExecute.ExecuteStatus.DELETE);
    }

    @ApiOperation(value = "修改库存入库删除")
    @PostMapping(value = "/delete/status/on")
    public R<String> deleteStatusOn(String id) {
        return new CompareExecute<>().compare(storeHouseInService.update(
                (StoreHouseIn) new StoreHouseIn()
                        .setDeleteStatus(StoreHouseInKey.DELETE_STATUS_ON)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "修改库存入库 not 删除")
    @PostMapping(value = "/delete/status/off")
    public R<String> deleteStatusOff(String id) {
        return new CompareExecute<>().compare(storeHouseInService.update(
                (StoreHouseIn) new StoreHouseIn()
                        .setDeleteStatus(StoreHouseInKey.DELETE_STATUS_OFF)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "修改库存入库 未入库")
    @PostMapping(value = "/store/house/in/status/off")
    public R<String> storeHouseInStatusOff(String id) {
        return new CompareExecute<>().compare(storeHouseInService.update(
                (StoreHouseIn) new StoreHouseIn()
                        .setDeleteStatus(StoreHouseInKey.STORE_HOUSE_IN_STATUS_OFF)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "修改库存入库 入库")
    @PostMapping(value = "/store/house/in/status/on")
    public R<String> storeHouseInStatusOn(String id) {
        return new CompareExecute<>().compare(storeHouseInService.update(
                (StoreHouseIn) new StoreHouseIn()
                        .setDeleteStatus(StoreHouseInKey.STORE_HOUSE_IN_STATUS_ON)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }
}
