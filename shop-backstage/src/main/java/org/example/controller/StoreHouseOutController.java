package org.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.service.StoreHouseOutService;
import org.example.entity.StoreHouseOut;
import org.example.entity.convert.StoreHouseOutConvert;
import org.example.entity.param.StoreHouseOutParam;
import org.example.entity.vo.StoreHouseOutVo;
import org.example.key.StoreHouseOutKey;
import org.example.model.PageR;
import org.example.model.R;
import org.example.result.CompareExecute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "库存出库")
@RestController
@RequestMapping(value = "/store/house/out")
public class StoreHouseOutController {
    @Autowired
    private StoreHouseOutService storeHouseOutService;
    @Autowired
    private StoreHouseOutConvert storeHouseOutConvert;

    @ApiOperation(value = "查询库存出库")
    @GetMapping(value = "/select")
    public PageR<List<StoreHouseOutVo>> select(StoreHouseOutParam storeHouseOutParam) {
        IPage<StoreHouseOut> iPage = storeHouseOutService.selectListByPage(storeHouseOutParam);
        return new PageR<List<StoreHouseOutVo>>().ok(storeHouseOutConvert.convert(iPage.getRecords()))
                .setCount(iPage.getTotal());
    }

    @ApiOperation(value = "新增库存出库")
    @PostMapping("/insert")
    public R<String> insert(@RequestBody StoreHouseOut storeHouseOut) {
        return new CompareExecute<>().compare(storeHouseOutService.insert(storeHouseOut), CompareExecute.ExecuteStatus.INSERT);
    }

    @ApiOperation(value = "修改库存出库")
    @PutMapping("/update")
    public R<String> update(@RequestBody StoreHouseOut storeHouseOut) {
        return new CompareExecute<>().compare(storeHouseOutService.update(storeHouseOut), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "删除库存出库")
    @DeleteMapping("/delete/{id}")
    public R<String> delete(@PathVariable("id") String id) {
        return new CompareExecute<>().compare(storeHouseOutService.delete(id), CompareExecute.ExecuteStatus.DELETE);
    }

    @ApiOperation(value = "修改库存出库删除")
    @PostMapping(value = "/delete/status/on")
    public R<String> deleteStatusOn(String id) {
        return new CompareExecute<>().compare(storeHouseOutService.update(
                (StoreHouseOut) new StoreHouseOut()
                        .setDeleteStatus(StoreHouseOutKey.DELETE_STATUS_ON)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "修改库存出库 not 删除")
    @PostMapping(value = "/delete/status/off")
    public R<String> deleteStatusOff(String id) {
        return new CompareExecute<>().compare(storeHouseOutService.update(
                (StoreHouseOut) new StoreHouseOut()
                        .setDeleteStatus(StoreHouseOutKey.DELETE_STATUS_OFF)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "修改库存出库 未出库")
    @PostMapping(value = "/store/house/in/status/off")
    public R<String> storeHouseInStatusOff(String id) {
        return new CompareExecute<>().compare(storeHouseOutService.update(
                (StoreHouseOut) new StoreHouseOut()
                        .setDeleteStatus(StoreHouseOutKey.STORE_HOUSE_OUT_STATUS_OFF)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "修改库存出库 出库")
    @PostMapping(value = "/store/house/in/status/on")
    public R<String> storeHouseInStatusOn(String id) {
        return new CompareExecute<>().compare(storeHouseOutService.update(
                (StoreHouseOut) new StoreHouseOut()
                        .setDeleteStatus(StoreHouseOutKey.STORE_HOUSE_OUT_STATUS_ON)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }
}
