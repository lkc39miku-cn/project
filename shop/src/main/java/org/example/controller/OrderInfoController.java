package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.example.entity.CommodityComment;
import org.example.entity.OrderInfo;
import org.example.entity.convert.OrderInfoConvert;
import org.example.entity.vo.CommodityBrandVo;
import org.example.entity.vo.OrderInfoVo;
import org.example.model.R;
import org.example.result.CompareExecute;
import org.example.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(value = "订单详情")
@RestController
@RequestMapping(value = "/order/info")
public class OrderInfoController {
    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private OrderInfoConvert orderInfoConvert;

    @ApiOperation(value = "订单详情查询")
    @GetMapping(value = "/select")
    public R<List<OrderInfoVo>> select(){
        return new R<List<OrderInfoVo>>()
                .ok(orderInfoConvert.convert(orderInfoService.select()));
    }

//    @ApiOperation(value = "订单的添加")
//    @PostMapping(value = "/insert")
//    public R<String> insert(@RequestBody OrderInfo orderInfo){
//        return new CompareExecute<>().compare(orderInfoService.insert(orderInfo),CompareExecute.ExecuteStatus.INSERT);
//    }

//    @ApiOperation(value = "订单的修改")
//    @PutMapping(value = "/update")
//    public R<String> update(@RequestBody OrderInfo orderInfo){
//        return new CompareExecute<>().compare(orderInfoService.update(orderInfo),CompareExecute.ExecuteStatus.UPDATE);
//    }


//    @ApiOperation(value = "删除评论")
//    @DeleteMapping("/delete{id}")
//    private R<String> delete(@PathVariable("id") String id){
//        return new CompareExecute<>().compare(commodityCommentService.delete(id),CompareExecute.ExecuteStatus.DELETE);
//    }

//    @ApiOperation(value = "订单删除")
//    @DeleteMapping(value = "/delete{id}")
//    public R<String> delete(@PathVariable("id") String id){
//        return  new CompareExecute<>().compare(orderInfoService.delete(id),CompareExecute.ExecuteStatus.DELETE);
//    }
}
