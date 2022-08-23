package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.mapper.StaffMapper;
import org.example.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;

}
