package org.example.service;

import org.example.entity.vo.StaffVo;

public interface StaffService {
    StaffVo selectByPrimaryKey(String id);
}
