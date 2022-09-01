package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.example.entity.Order;
import org.example.entity.convert.OrderConvert;
import org.example.entity.vo.OrderVo;
import org.example.model.R;
import org.example.result.CompareExecute;
import org.example.service.OrderService;
import org.example.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "订单")
@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderConvert orderConvert;


    @ApiOperation(value = "订单查询")
    @GetMapping(value = "/select")
    private R<List<OrderVo>> select(){
        return new R<List<OrderVo>>()
                .ok(orderConvert.convert(orderService.select()));
    }

//    @ApiOperation(value = "订单添加")
//    @PostMapping (value = "/insert")
//    private R<String> insert(@RequestBody Order order){
//        return new CompareExecute<>().compare(orderService.insert(order),CompareExecute.ExecuteStatus.INSERT);
//    }
//
    @ApiOperation(value = "订单修改")
    @PutMapping (value = "/update")
    private R<String> update(@RequestBody Order order){
        return new CompareExecute<>().compare(orderService.update(order),CompareExecute.ExecuteStatus.UPDATE);
    }



}
