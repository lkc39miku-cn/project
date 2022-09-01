package org.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.service.StoreHouseService;
import org.example.entity.StoreHouse;
import org.example.entity.convert.StoreHouseConvert;
import org.example.entity.param.StoreHouseParam;
import org.example.entity.vo.StoreHouseVo;
import org.example.key.StoreHouseKey;
import org.example.model.PageR;
import org.example.model.R;
import org.example.result.CompareExecute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "库存")
@RestController
@RequestMapping(value = "/store/house")
public class StoreHouseController {
    @Autowired
    private StoreHouseService storeHouseService;
    @Autowired
    private StoreHouseConvert storeHouseConvert;

    @ApiOperation(value = "查询库存")
    @GetMapping(value = "/select")
    public PageR<List<StoreHouseVo>> select(StoreHouseParam storeHouseParam) {
        IPage<StoreHouse> iPage = storeHouseService.selectListByPage(storeHouseParam);
        return new PageR<List<StoreHouseVo>>().ok(storeHouseConvert.convert(iPage.getRecords()))
                .setCount(iPage.getTotal());
    }

    @ApiOperation(value = "新增库存")
    @PostMapping("/insert")
    public R<String> insert(@RequestBody StoreHouse storeHouse) {
        return new CompareExecute<>().compare(storeHouseService.insert(storeHouse), CompareExecute.ExecuteStatus.INSERT);
    }

    @ApiOperation(value = "修改库存")
    @PutMapping("/update")
    public R<String> update(@RequestBody StoreHouse storeHouse) {
        return new CompareExecute<>().compare(storeHouseService.update(storeHouse), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "删除库存")
    @DeleteMapping("/delete/{id}")
    public R<String> delete(@PathVariable("id") String id) {
        return new CompareExecute<>().compare(storeHouseService.delete(id), CompareExecute.ExecuteStatus.DELETE);
    }

    @ApiOperation(value = "修改库存删除")
    @PostMapping(value = "/delete/status/on")
    public R<String> deleteStatusOn(String id) {
        return new CompareExecute<>().compare(storeHouseService.update(
                (StoreHouse) new StoreHouse()
                        .setDeleteStatus(StoreHouseKey.DELETE_STATUS_ON)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "修改库存 not 删除")
    @PostMapping(value = "/delete/status/off")
    public R<String> deleteStatusOff(String id) {
        return new CompareExecute<>().compare(storeHouseService.update(
                (StoreHouse) new StoreHouse()
                        .setDeleteStatus(StoreHouseKey.DELETE_STATUS_OFF)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }
}
