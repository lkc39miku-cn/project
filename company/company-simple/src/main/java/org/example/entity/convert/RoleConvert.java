package org.example.entity.convert;

import org.example.entity.Role;
import org.example.entity.vo.RoleVo;
import org.example.util.Convert;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class RoleConvert implements Convert<Role, RoleVo> {
    @Override
    public abstract RoleVo convert(Role role);
    @Override
    public abstract List<RoleVo> convert(List<Role> roleList);

    @AfterMapping
    public void convert(Role role, RoleVo roleVo) {
    }

    @AfterMapping
    public void convert(List<Role> roleList, List<RoleVo> roleVoList) {
    }
}
