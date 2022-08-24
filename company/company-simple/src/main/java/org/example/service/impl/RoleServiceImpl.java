package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.example.entity.Role;
import org.example.entity.RoleDept;
import org.example.entity.Staff;
import org.example.entity.StaffRole;
import org.example.entity.convert.RoleConvert;
import org.example.entity.param.RoleParam;
import org.example.entity.param.StaffParam;
import org.example.entity.vo.RoleVo;
import org.example.exception.service.ServiceException;
import org.example.mapper.RoleDeptMapper;
import org.example.mapper.RoleMapper;
import org.example.mapper.StaffMapper;
import org.example.mapper.StaffRoleMapper;
import org.example.model.R;
import org.example.service.RoleService;
import org.example.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private RoleDeptMapper roleDeptMapper;
    @Autowired
    private StaffRoleMapper staffRoleMapper;
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
    public IPage<Staff> selectAssigned(StaffParam staffParam) {
        return staffMapper.selectAssigned(new Page<>(PageUtil.page(), PageUtil.pageSize()), staffParam);
    }

    @Override
    public IPage<Staff> selectUnAssigned(StaffParam staffParam) {
        return staffMapper.selectUnAssigned(new Page<>(PageUtil.page(), PageUtil.pageSize()), staffParam);
    }

    @Override
    public List<RoleVo> selectList(RoleParam roleParam) {
        return roleConvert.convert(roleMapper.selectList(new LambdaQueryWrapper<Role>()
                .eq(Objects.nonNull(roleParam.getStatus()), Role::getStatus, roleParam.getStatus())
                .eq(Objects.nonNull(roleParam.getDeleteStatus()), Role::getDeleteStatus, roleParam.getDeleteStatus())));
    }

    @Override
    public boolean checkName(String name) {
        return Objects.nonNull(roleMapper.selectOne(new LambdaQueryWrapper<Role>()
                .eq(Role::getName, name)));
    }

    @Override
    public boolean checkRoleKey(String roleKey) {
        return Objects.nonNull(roleMapper.selectOne(new LambdaQueryWrapper<Role>()
                .eq(Role::getRoleKey, roleKey)));
    }

    @Override
    public boolean checkName(String name, String id) {
        return Objects.nonNull(roleMapper.selectOne(new LambdaQueryWrapper<Role>()
                .eq(Role::getName, name)
                .ne(Role::getId, id)));
    }

    @Override
    public boolean checkRoleKey(String roleKey, String id) {
        return Objects.nonNull(roleMapper.selectOne(new LambdaQueryWrapper<Role>()
                .eq(Role::getRoleKey, roleKey)
                .ne(Role::getId, id)));
    }

    @Override
    public int insert(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int update(Role role) {
        return roleMapper.updateById(role);
    }

    @Override
    public int delete(String id) {
        return roleMapper.deleteById(id);
    }

    @Override
    public int authDataScope(RoleParam roleParam) {
        roleDeptMapper.delete(new LambdaQueryWrapper<RoleDept>()
                .eq(RoleDept::getRoleId, roleParam.getId()));
        return roleDeptMapper.insertBatch(roleParam.getDeptIdList(), roleParam.getId());
    }

    @Override
    public int cancelAssign(StaffRole staffRole) {
        return staffRoleMapper.delete(new LambdaQueryWrapper<StaffRole>()
                .eq(StaffRole::getStaffId, staffRole.getStaffId())
                .eq(StaffRole::getRoleId, staffRole.getRoleId()));
    }

    @Override
    public int cancelAssignBatch(String id, List<String> staffIdList) {
        return staffRoleMapper.delete(new LambdaQueryWrapper<StaffRole>()
                .eq(StaffRole::getRoleId, id)
                .in(StaffRole::getStaffId, staffIdList));
    }

    @Override
    public int assignBatch(String id, List<String> staffIdList) {
        return staffRoleMapper.assignBatch(id, staffIdList);
    }

    @Override
    public void checkRoleAllowed(Role role) {
        if (StringUtils.isNotEmpty(role.getId()) && role.isAdmin()) {
            throw new ServiceException("不允许操作超级管理员角色");
        }
    }
}
