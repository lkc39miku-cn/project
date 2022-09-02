package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.entity.Order;
import org.example.entity.convert.OrderConvert;
import org.example.entity.param.OrderParam;
import org.example.model.R;
import org.example.result.CompareExecute;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "订单")
@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderConvert orderConvert;

    @ApiOperation(value = "添加订单")
    @PostMapping(value = "/insert")
    public R<String> insert(@RequestBody OrderParam orderParam) {
        return new CompareExecute<>().compare(
                orderService.insert(orderParam),
                CompareExecute.ExecuteStatus.INSERT
        );
    }

    @GetMapping(value = "/pay")
    public void pay(HttpServletRequest request) {
        orderService.pay(request);
    }
}
