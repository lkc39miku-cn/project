package org.example.controller;

import org.example.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order/info")
public class OrderInfoController {
    @Autowired
    private OrderInfoService orderInfoService;
}
