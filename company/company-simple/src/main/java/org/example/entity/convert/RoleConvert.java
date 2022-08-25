package org.example.entity.convert;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.entity.Role;
import org.example.entity.Staff;
import org.example.entity.vo.RoleVo;
import org.example.mapper.StaffMapper;
import org.example.util.Convert;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class RoleConvert implements Convert<Role, RoleVo> {
    @Autowired
    private StaffMapper staffMapper;
    @Override
    public abstract RoleVo convert(Role role);
    @Override
    public abstract List<RoleVo> convert(List<Role> roleList);

    @AfterMapping
    public void convert(Role role, @MappingTarget RoleVo roleVo) {
        roleVo.setCreateStaff(staffMapper.selectOne(new LambdaQueryWrapper<Staff>()
                .eq(Staff::getId, roleVo.getCreateStaffId())));
    }

    @AfterMapping
    public void convert(List<Role> roleList, @MappingTarget List<RoleVo> roleVoList) {
        roleVoList.forEach(v -> convert(null, v));
    }
}
