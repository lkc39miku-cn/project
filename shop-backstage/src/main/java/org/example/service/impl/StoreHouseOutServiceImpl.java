package org.example.service.impl;

import org.example.mapper.StoreHouseOutMapper;
import org.example.StoreHouseOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreHouseOutServiceImpl implements StoreHouseOutService {
    @Autowired
    private StoreHouseOutMapper storeHouseOutMapper;
}
