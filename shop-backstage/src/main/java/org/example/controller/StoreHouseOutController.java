package org.example.controller;

import org.example.StoreHouseOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/store/house/out")
public class StoreHouseOutController {
    @Autowired
    private StoreHouseOutService storeHouseOutService;
}
