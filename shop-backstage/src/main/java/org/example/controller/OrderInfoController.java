package org.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.OrderInfoService;
import org.example.entity.Commodity;
import org.example.entity.OrderInfo;
import org.example.entity.convert.OrderInfoConvert;
import org.example.entity.param.CommodityParam;
import org.example.entity.param.OrderInfoParam;
import org.example.entity.vo.CommodityVo;
import org.example.entity.vo.OrderInfoVo;
import org.example.key.CommodityKey;
import org.example.model.PageR;
import org.example.model.R;
import org.example.result.CompareExecute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "订单详情")
@RestController
@RequestMapping(value = "/order/info")
public class OrderInfoController {
    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private OrderInfoConvert orderInfoConvert;

    @ApiOperation(value = "查询订单详情")
    @GetMapping(value = "/select")
    public R<List<OrderInfoVo>> select(OrderInfoParam orderInfoParam) {
        return new R<List<OrderInfoVo>>().ok(orderInfoConvert.convert(orderInfoService.selectList(orderInfoParam)));
    }

    @ApiOperation(value = "新增订单详情")
    @PostMapping("/insert")
    public R<String> insert(@RequestBody OrderInfo orderInfo) {
        return new CompareExecute<>().compare(orderInfoService.insert(orderInfo), CompareExecute.ExecuteStatus.INSERT);
    }

    @ApiOperation(value = "修改订单详情")
    @PutMapping("/update")
    public R<String> update(@RequestBody OrderInfo orderInfo) {
        return new CompareExecute<>().compare(orderInfoService.update(orderInfo), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "删除订单详情")
    @DeleteMapping("/delete/{id}")
    public R<String> delete(@PathVariable("id") String id) {
        return new CompareExecute<>().compare(orderInfoService.delete(id), CompareExecute.ExecuteStatus.DELETE);
    }

    @ApiOperation(value = "修改订单详情显示")
    @PostMapping(value = "/publish/status/on")
    public R<String> publishStatusOn(String id) {
        return new CompareExecute<>().compare(orderInfoService.update(
                (OrderInfo) new OrderInfo()
                        .setPublishStatus(CommodityKey.PUBLISH_STATUS_ON)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "修改订单详情隐藏")
    @PostMapping(value = "/publish/status/off")
    public R<String> publishStatusOff(String id) {
        return new CompareExecute<>().compare(orderInfoService.update(
                (OrderInfo) new OrderInfo()
                        .setPublishStatus(CommodityKey.PUBLISH_STATUS_OFF)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "修改订单详情删除")
    @PostMapping(value = "/delete/status/on")
    public R<String> deleteStatusOn(String id) {
        return new CompareExecute<>().compare(orderInfoService.update(
                (OrderInfo) new OrderInfo()
                        .setDeleteStatus(CommodityKey.DELETE_STATUS_ON)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "修改订单详情 not 删除")
    @PostMapping(value = "/delete/status/off")
    public R<String> deleteStatusOff(String id) {
        return new CompareExecute<>().compare(orderInfoService.update(
                (OrderInfo) new OrderInfo()
                        .setDeleteStatus(CommodityKey.DELETE_STATUS_OFF)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }
}
