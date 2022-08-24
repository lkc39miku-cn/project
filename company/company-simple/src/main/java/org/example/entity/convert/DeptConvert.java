package org.example.entity.convert;

import org.example.entity.Dept;
import org.example.util.Convert;
import org.example.entity.vo.DeptVo;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class DeptConvert implements Convert<Dept, DeptVo> {
    @Override
    public abstract DeptVo convert(Dept dept);
    @Override
    public abstract List<DeptVo> convert(List<Dept> deptList);

    @AfterMapping
    public void convert(Dept dept, DeptVo deptVo) {
    }

    @AfterMapping
    public void convert(List<Dept> deptList, List<DeptVo> deptVoList) {
    }
}
