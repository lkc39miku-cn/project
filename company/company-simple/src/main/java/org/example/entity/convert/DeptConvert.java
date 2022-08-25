package org.example.entity.convert;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.entity.Dept;
import org.example.entity.Staff;
import org.example.mapper.StaffMapper;
import org.example.util.Convert;
import org.example.entity.vo.DeptVo;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class DeptConvert implements Convert<Dept, DeptVo> {
    @Autowired
    private StaffMapper staffMapper;
    @Override
    public abstract DeptVo convert(Dept dept);
    @Override
    public abstract List<DeptVo> convert(List<Dept> deptList);

    @AfterMapping
    public void convert(Dept dept, @MappingTarget DeptVo deptVo) {
        deptVo.setCreateStaff(staffMapper.selectOne(new LambdaQueryWrapper<Staff>()
                .eq(Staff::getId, deptVo.getCreateStaffId())))
              .setLeaderStaff(staffMapper.selectOne(new LambdaQueryWrapper<Staff>()
                .eq(Staff::getId, deptVo.getLeaderId())));
    }

    @AfterMapping
    public void convert(List<Dept> deptList, @MappingTarget List<DeptVo> deptVoList) {
        deptVoList.forEach(v -> convert(null, v));
    }
}
