package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.convert.StaffConvert;
import org.example.entity.vo.StaffVo;
import org.example.mapper.StaffMapper;
import org.example.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private StaffConvert staffConvert;

    @Override
    public StaffVo selectByPrimaryKey(String id) {
        return staffConvert.convert(staffMapper.selectById(id));
    }
}
