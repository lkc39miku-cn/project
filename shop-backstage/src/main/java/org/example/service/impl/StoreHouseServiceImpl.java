package org.example.service.impl;

import org.example.mapper.StoreHouseMapper;
import org.example.StoreHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreHouseServiceImpl implements StoreHouseService {
    @Autowired
    private StoreHouseMapper storeHouseMapper;
}
