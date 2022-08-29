package org.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.CommodityService;
import org.example.entity.Commodity;
import org.example.entity.convert.CommodityConvert;
import org.example.entity.param.CommodityParam;
import org.example.entity.vo.CommodityVo;
import org.example.model.PageR;
import org.example.model.R;
import org.example.result.CompareExecute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;
    @Autowired
    private CommodityConvert commodityConvert;

    @PostMapping("/insert")
    public R<String> insert(@RequestBody Commodity commodity) {
        return new CompareExecute<>().compare(commodityService.insert(commodity), CompareExecute.ExecuteStatus.INSERT);
    }

    @PutMapping("/update")
    public R<String> update(@RequestBody Commodity commodity) {
        return new CompareExecute<>().compare(commodityService.update(commodity), CompareExecute.ExecuteStatus.UPDATE);
    }

    @DeleteMapping("/delete/{id}")
    public R<String> delete(@PathVariable("id") String id) {
        return new CompareExecute<>().compare(commodityService.delete(id), CompareExecute.ExecuteStatus.DELETE);
    }
}
