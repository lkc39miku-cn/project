package org.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.OrderService;
import org.example.entity.Commodity;
import org.example.entity.Order;
import org.example.entity.OrderInfo;
import org.example.entity.convert.OrderConvert;
import org.example.entity.param.OrderInfoParam;
import org.example.entity.param.OrderParam;
import org.example.entity.vo.OrderInfoVo;
import org.example.entity.vo.OrderVo;
import org.example.key.CommodityKey;
import org.example.key.OrderKey;
import org.example.model.PageR;
import org.example.model.R;
import org.example.result.CompareExecute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "订单")
@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderConvert orderConvert;

    @ApiOperation(value = "查询订单")
    @GetMapping(value = "/select")
    public PageR<List<OrderVo>> select(OrderParam orderParam) {
        IPage<Order> iPage = orderService.selectListByPage(orderParam);
        return new PageR<List<OrderVo>>().ok(orderConvert.convert(iPage.getRecords()))
                .setCount(iPage.getTotal());
    }

    @ApiOperation(value = "新增订单")
    @PostMapping("/insert")
    public R<String> insert(@RequestBody Order order) {
        return new CompareExecute<>().compare(orderService.insert(order), CompareExecute.ExecuteStatus.INSERT);
    }

    @ApiOperation(value = "修改订单")
    @PutMapping("/update")
    public R<String> update(@RequestBody Order order) {
        return new CompareExecute<>().compare(orderService.update(order), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "删除订单")
    @DeleteMapping("/delete/{id}")
    public R<String> delete(@PathVariable("id") String id) {
        return new CompareExecute<>().compare(orderService.delete(id), CompareExecute.ExecuteStatus.DELETE);
    }

    @ApiOperation(value = "修改订单显示")
    @PostMapping(value = "/publish/status/on")
    public R<String> publishStatusOn(String id) {
        return new CompareExecute<>().compare(orderService.update(
                (OrderVo) new OrderVo()
                        .setPublishStatus(OrderKey.PUBLISH_STATUS_ON)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "修改订单隐藏")
    @PostMapping(value = "/publish/status/off")
    public R<String> publishStatusOff(String id) {
        return new CompareExecute<>().compare(orderService.update(
                (OrderVo) new OrderVo()
                        .setPublishStatus(OrderKey.PUBLISH_STATUS_OFF)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "修改订单删除")
    @PostMapping(value = "/delete/status/on")
    public R<String> deleteStatusOn(String id) {
        return new CompareExecute<>().compare(orderService.update(
                (OrderVo) new OrderVo()
                        .setDeleteStatus(OrderKey.DELETE_STATUS_ON)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "修改订单 not 删除")
    @PostMapping(value = "/delete/status/off")
    public R<String> deleteStatusOff(String id) {
        return new CompareExecute<>().compare(orderService.update(
                (OrderVo) new OrderVo()
                        .setDeleteStatus(OrderKey.DELETE_STATUS_OFF)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }
}
