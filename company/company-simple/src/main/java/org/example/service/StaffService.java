package org.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.entity.Staff;
import org.example.entity.param.StaffParam;
import org.example.entity.vo.StaffVo;

import java.util.List;

public interface StaffService {
    StaffVo selectByPrimaryKey(String id);

    IPage<Staff> selectListByPage(StaffParam staffParam);

    boolean checkStaffUsername(String username);

    boolean checkStaffPhone(String phone);

    boolean checkStaffEmail(String email);

    boolean checkStaffUsername(String username, String id);

    boolean checkStaffPhone(String phone, String id);

    boolean checkStaffEmail(String email, String id);

    int insert(Staff staff);
    int update(Staff staff);

    int delete(String id);

    int updateRole(String id, List<String> roleIdList);

    void checkStaffAllowed(Staff staff);


}
