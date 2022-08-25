package org.example.entity.convert;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.entity.Dept;
import org.example.entity.Role;
import org.example.entity.Staff;
import org.example.entity.StaffRole;
import org.example.entity.vo.StaffVo;
import org.example.mapper.DeptMapper;
import org.example.mapper.RoleMapper;
import org.example.mapper.StaffMapper;
import org.example.mapper.StaffRoleMapper;
import org.example.util.Convert;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class StaffConvert implements Convert<Staff, StaffVo> {
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private StaffRoleMapper staffRoleMapper;
    @Autowired
    private RoleConvert roleConvert;
    @Override
    public abstract StaffVo convert(Staff staff);
    @Override
    public abstract List<StaffVo> convert(List<Staff> staffList);

    @AfterMapping
    public void convert(Staff staff, @MappingTarget StaffVo staffVo) {
        staffVo.setCreateStaff(staffMapper.selectOne(new LambdaQueryWrapper<Staff>()
                .eq(Staff::getId, staffVo.getCreateStaffId())))
                .setDept(deptMapper.selectOne(new LambdaQueryWrapper<Dept>()
                        .eq(Dept::getId, staffVo.getDeptId())));

        List<StaffRole> staffRoleList = staffRoleMapper.selectList(new LambdaQueryWrapper<StaffRole>()
                .eq(StaffRole::getStaffId, staffVo.getId()));

        staffVo.setRoleList(staffRoleList.size() > 0 ? roleConvert.convert((roleMapper.selectList(new LambdaQueryWrapper<Role>()
                .in(Role::getId, staffRoleList)))) : null);
    }

    @AfterMapping
    public void convert(List<Staff> staffList, @MappingTarget List<StaffVo> staffVoList) {
        staffVoList.forEach(v -> convert(null, v));
    }
}
