package org.example.entity.convert;

import org.example.entity.Menu;
import org.example.entity.vo.MenuVo;
import org.example.util.Convert;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class MenuConvert implements Convert<Menu, MenuVo> {
    public abstract MenuVo convert(Menu menu);
    public abstract List<MenuVo> convert(List<Menu> menuList);

    @AfterMapping
    public void convert(Menu menu, MenuVo menuVo) {
    }

    @AfterMapping
    public void convert(List<Menu> menuList, List<MenuVo> menuVoList) {
    }
}
