package org.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.entity.Role;
import org.example.entity.param.RoleParam;
import org.example.entity.vo.RoleVo;

public interface RoleService {
    RoleVo selectByPrimaryKey(String id);

    IPage<Role> selectListByPage(RoleParam roleParam);

    boolean checkName(String name);

    boolean checkRoleKey(String roleKey);

    int insert(Role role);
}
