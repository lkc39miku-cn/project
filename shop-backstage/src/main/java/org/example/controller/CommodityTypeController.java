package org.example.controller;

import org.example.CommodityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/commodity/type")
public class CommodityTypeController {
    @Autowired
    private CommodityTypeService commodityTypeService;
}
