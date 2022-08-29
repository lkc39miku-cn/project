package org.example.controller;

import org.example.StoreHouseInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/store/house/in")
public class StoreHouseInController {
    @Autowired
    private StoreHouseInService storeHouseInService;

}
