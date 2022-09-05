package org.example.controller;

import com.alipay.api.AlipayApiException;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.entity.Order;
import org.example.entity.convert.OrderConvert;
import org.example.entity.param.OrderParam;
import org.example.entity.vo.OrderVo;
import org.example.model.PageR;
import org.example.model.R;
import org.example.result.CompareExecute;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(tags = "订单")
@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderConvert orderConvert;

    @ApiOperation(value = "查询用户订单")
    @GetMapping(value = "/select")
    public PageR<List<OrderVo>> select(OrderParam orderParam) {
        IPage<Order> orderIPage = orderService.selectListByPage(orderParam);
        return new PageR<List<OrderVo>>()
                .ok(orderConvert.convert(orderIPage.getRecords()))
                .setCount(orderIPage.getTotal());
    }

    @ApiOperation(value = "添加订单")
    @PostMapping(value = "/insert")
    public R<String> insert(@RequestBody OrderParam orderParam) {
        return new CompareExecute<>().compare(
                orderService.insert(orderParam),
                CompareExecute.ExecuteStatus.INSERT
        );
    }

    @GetMapping(value = "/pay")
    public void pay(HttpServletRequest request) throws AlipayApiException {
        orderService.pay(request);
    }
}
