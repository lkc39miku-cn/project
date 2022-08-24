package org.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.entity.Role;
import org.example.entity.Staff;
import org.example.entity.StaffRole;
import org.example.entity.param.RoleParam;
import org.example.entity.param.StaffParam;
import org.example.entity.vo.RoleVo;

import java.util.List;

public interface RoleService {
    RoleVo selectByPrimaryKey(String id);

    IPage<Role> selectListByPage(RoleParam roleParam);

    IPage<Staff> selectAssigned(StaffParam staffParam);

    IPage<Staff> selectUnAssigned(StaffParam staffParam);

    List<RoleVo> selectList(RoleParam roleParam);

    boolean checkName(String name);

    boolean checkRoleKey(String roleKey);

    boolean checkName(String name, String id);

    boolean checkRoleKey(String roleKey, String id);

    int insert(Role role);

    int update(Role role);

    int delete(String id);

    int authDataScope(RoleParam roleParam);

    int cancelAssign(StaffRole staffRole);

    int cancelAssignBatch(String id, List<String> staffIdList);

    int assignBatch(String id, List<String> staffIdList);

    void checkRoleAllowed(Role role);

}
