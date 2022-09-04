package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.example.entity.Staff;
import org.example.entity.StaffRole;
import org.example.entity.convert.StaffConvert;
import org.example.entity.param.StaffParam;
import org.example.entity.vo.StaffVo;
import org.example.exception.service.ServiceException;
import org.example.key.StaffKey;
import org.example.mapper.StaffMapper;
import org.example.mapper.StaffRoleMapper;
import org.example.service.StaffService;
import org.example.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private StaffRoleMapper staffRoleMapper;
    @Autowired
    private StaffConvert staffConvert;

    @Override
    public StaffVo selectByPrimaryKey(String id) {
        return staffConvert.convert(staffMapper.selectById(id));
    }

    @Override
    public IPage<Staff> selectListByPage(StaffParam staffParam) {
        return staffMapper.selectPage(new Page<>(PageUtil.page(), PageUtil.pageSize()), new LambdaQueryWrapper<Staff>()
                .eq(StringUtils.isNotEmpty(staffParam.getUsername()), Staff::getUsername, staffParam.getUsername())
                .eq(StringUtils.isNotEmpty(staffParam.getPhone()), Staff::getPhone, staffParam.getPhone())
                .eq(StringUtils.isNotEmpty(staffParam.getEmail()), Staff::getEmail, staffParam.getEmail())
                .eq(StringUtils.isNotEmpty(staffParam.getDeptId()), Staff::getDeptId, staffParam.getDeptId()));
    }

    @Override
    public boolean checkStaffUsername(String username) {
        return Objects.nonNull(staffMapper.selectOne(new LambdaQueryWrapper<Staff>()
                .eq(Staff::getUsername, username)));
    }

    @Override
    public boolean checkStaffPhone(String phone) {
        return Objects.nonNull(staffMapper.selectOne(new LambdaQueryWrapper<Staff>()
                .eq(Staff::getPhone, phone)));
    }

    @Override
    public boolean checkStaffEmail(String email) {
        return Objects.nonNull(staffMapper.selectOne(new LambdaQueryWrapper<Staff>()
                .eq(Staff::getEmail, email)));
    }

    @Override
    public boolean checkStaffUsername(String username, String id) {
        return Objects.nonNull(staffMapper.selectOne(new LambdaQueryWrapper<Staff>()
                .eq(Staff::getUsername, username)
                .ne(Staff::getId, id)));
    }

    @Override
    public boolean checkStaffPhone(String phone, String id) {
        return Objects.nonNull(staffMapper.selectOne(new LambdaQueryWrapper<Staff>()
                .eq(Staff::getPhone, phone)
                .ne(Staff::getId, id)));
    }

    @Override
    public boolean checkStaffEmail(String email, String id) {
        return Objects.nonNull(staffMapper.selectOne(new LambdaQueryWrapper<Staff>()
                .eq(Staff::getEmail, email)
                .ne(Staff::getId, id)));
    }

    @Override
    public int insert(Staff staff) {
        return staffMapper.insert(staff);
    }

    @Override
    public int update(Staff staff) {
        return staffMapper.updateById(staff);
    }

    @Override
    public int delete(String id) {
        return staffMapper.updateById((Staff) new Staff()
                .setDeleteStatus(StaffKey.IS_DELETE)
                .setId(id));
    }

    @Override
    public int updateRole(String id, List<String> roleIdList) {
        log.info("id " + id);
        log.info("roleIdList " + roleIdList);
        staffRoleMapper.delete(new LambdaQueryWrapper<StaffRole>()
                .eq(StaffRole::getStaffId, id));

        return staffRoleMapper.insertBatch(id, roleIdList);
    }

    @Override
    public void checkStaffAllowed(Staff staff) {
        if (StringUtils.isNotEmpty(staff.getId()) && staff.isAdmin()) {
            throw new ServiceException("不允许操作超级管理员用户");
        }
    }
}
