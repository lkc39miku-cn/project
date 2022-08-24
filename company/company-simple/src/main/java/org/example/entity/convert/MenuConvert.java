package org.example.entity.convert;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.entity.Menu;
import org.example.entity.Staff;
import org.example.entity.vo.MenuVo;
import org.example.mapper.StaffMapper;
import org.example.util.Convert;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class MenuConvert implements Convert<Menu, MenuVo> {
    @Autowired
    private StaffMapper staffMapper;
    @Override
    public abstract MenuVo convert(Menu menu);
    @Override
    public abstract List<MenuVo> convert(List<Menu> menuList);

    @AfterMapping
    public void convert(Menu menu, MenuVo menuVo) {
        menuVo.setCreateStaff(staffMapper.selectOne(new LambdaQueryWrapper<Staff>()
                .eq(Staff::getId, menuVo.getCreateStaffId())));
    }

    @AfterMapping
    public void convert(List<Menu> menuList, List<MenuVo> menuVoList) {
        menuVoList.forEach(v -> convert(null, v));
    }
}
