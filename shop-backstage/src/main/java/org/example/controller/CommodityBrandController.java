package org.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.service.CommodityBrandService;
import org.example.entity.CommodityBrand;
import org.example.entity.convert.CommodityBrandConvert;
import org.example.entity.param.CommodityBrandParam;
import org.example.entity.vo.CommodityBrandVo;
import org.example.key.CommodityBrandKey;
import org.example.model.PageR;
import org.example.model.R;
import org.example.result.CompareExecute;
import org.example.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品品牌")
@RestController
@RequestMapping(value = "/commodity/brand")
public class CommodityBrandController {
    @Autowired
    private CommodityBrandService commodityBrandService;
    @Autowired
    private CommodityBrandConvert commodityBrandConvert;
    @Autowired
    private RedisCache redisCache;

    @ApiOperation(value = "查询商品品牌")
    @GetMapping(value = "/select")
    public PageR<List<CommodityBrandVo>> select(CommodityBrandParam commodityBrandParam) {
        IPage<CommodityBrand> iPage = commodityBrandService.selectListByPage(commodityBrandParam);
        return new PageR<List<CommodityBrandVo>>().ok(commodityBrandConvert.convert(iPage.getRecords()))
                .setCount(iPage.getTotal());
    }

    @ApiOperation(value = "新增商品品牌")
    @PostMapping("/insert")
    public R<String> insert(@RequestBody CommodityBrand commodityBrand) {
        return new CompareExecute<>().compare(commodityBrandService.insert(commodityBrand), CompareExecute.ExecuteStatus.INSERT);
    }

    @ApiOperation(value = "修改商品品牌")
    @PutMapping("/update")
    public R<String> update(@RequestBody CommodityBrand commodityBrand) {
        return new CompareExecute<>().compare(commodityBrandService.update(commodityBrand), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "删除商品品牌")
    @DeleteMapping("/delete/{id}")
    public R<String> delete(@PathVariable("id") String id) {
        return new CompareExecute<>().compare(commodityBrandService.delete(id), CompareExecute.ExecuteStatus.DELETE);
    }

    @ApiOperation(value = "修改商品品牌显示")
    @PostMapping(value = "/publish/status/on")
    public R<String> publishStatusOn(String id) {
        return new CompareExecute<>().compare(commodityBrandService.update(
                (CommodityBrand) new CommodityBrand()
                        .setPublishStatus(CommodityBrandKey.PUBLISH_STATUS_ON)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "修改商品品牌隐藏")
    @PostMapping(value = "/publish/status/off")
    public R<String> publishStatusOff(String id) {
        return new CompareExecute<>().compare(commodityBrandService.update(
                (CommodityBrand) new CommodityBrand()
                        .setPublishStatus(CommodityBrandKey.PUBLISH_STATUS_OFF)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }
}
