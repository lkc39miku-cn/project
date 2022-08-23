package org.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Role;
import org.example.entity.convert.RoleConvert;
import org.example.entity.param.RoleParam;
import org.example.entity.vo.RoleVo;
import org.example.mapper.RoleMapper;
import org.example.service.RoleService;
import org.example.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleConvert roleConvert;

    @Override
    public RoleVo selectByPrimaryKey(String id) {
        return roleConvert.convert(roleMapper.selectById(id));
    }

    @Override
    public IPage<Role> selectListByPage(RoleParam roleParam) {
        return roleMapper.selectPage(new Page<>(PageUtil.page(), PageUtil.pageSize()), null);
    }

    @Override
    public boolean checkName(String name) {
        return false;
    }

    @Override
    public boolean checkRoleKey(String roleKey) {
        return false;
    }

    @Override
    public int insert(Role role) {
        return 0;
    }
}
