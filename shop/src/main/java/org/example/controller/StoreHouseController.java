package org.example.controller;

import org.example.service.StoreHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/store/house")
public class StoreHouseController {
    @Autowired
    private StoreHouseService storeHouseService;
}
