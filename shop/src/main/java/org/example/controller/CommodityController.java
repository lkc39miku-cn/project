package org.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.entity.Commodity;
import org.example.entity.convert.CommodityConvert;
import org.example.entity.param.CommodityParam;
import org.example.entity.vo.CommodityVo;
import org.example.model.PageR;
import org.example.model.R;
import org.example.result.CompareExecute;
import org.example.service.CommodityService;
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

    @GetMapping(value = "/select")
    public PageR<List<CommodityVo>> select(CommodityParam commodityParam) {
        IPage<Commodity> iPage = commodityService.selectListByPage(commodityParam);
        return new PageR<List<CommodityVo>>().ok(commodityConvert.convert(iPage.getRecords()))
                .setCount(iPage.getTotal());
    }
}
