package org.example.entity.convert;

import org.example.entity.Staff;
import org.example.entity.vo.StaffVo;
import org.example.util.Convert;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class StaffConvert implements Convert<Staff, StaffVo> {
    @Override
    public abstract StaffVo convert(Staff staff);
    @Override
    public abstract List<StaffVo> convert(List<Staff> staffList);

    @AfterMapping
    public void convert(Staff staff, StaffVo staffVo) {
    }

    @AfterMapping
    public void convert(List<Staff> staffList, List<StaffVo> staffVoList) {
    }
}
