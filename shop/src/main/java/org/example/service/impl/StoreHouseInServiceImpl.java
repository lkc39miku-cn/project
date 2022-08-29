package org.example.service.impl;

import org.example.mapper.StoreHouseInMapper;
import org.example.service.StoreHouseInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreHouseInServiceImpl implements StoreHouseInService {
    @Autowired
    private StoreHouseInMapper storeHouseInMapper;
}
