package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.example.entity.Menu;
import org.example.entity.RoleMenu;
import org.example.entity.convert.MenuConvert;
import org.example.entity.vo.MenuVo;
import org.example.mapper.MenuMapper;
import org.example.mapper.RoleMenuMapper;
import org.example.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Autowired
    private MenuConvert menuConvert;

    @Override
    public Set<String> selectMenuPermsByStaffId(String id) {
        List<String> menuList = menuMapper.selectMenuPermsByStaffId(id);
        Set<String> set = new HashSet<>(10);
        menuList.stream().filter(StringUtils::isNoneEmpty).forEach(v -> set.addAll(Arrays.asList(v.trim().split(","))));
        return set;
    }

    @Override
    public MenuVo selectByPrimaryKey(String id) {
        return menuConvert.convert(menuMapper.selectById(id));
    }

    @Override
    public List<MenuVo> selectList(Menu menu) {
        return menuConvert.convert(menuMapper.selectList(new LambdaQueryWrapper<Menu>()
                .eq(Objects.nonNull(menu.getVisible()), Menu::getVisible, menu.getVisible())
                .eq(Objects.nonNull(menu.getStatus()), Menu::getStatus, menu.getStatus())));
    }

    @Override
    public List<MenuVo> tree(List<MenuVo> menuVoList) {
        List<MenuVo> tree = new ArrayList<>();
        menuVoList.forEach(v -> {
            if (v.getParentId().equals("0")) {
                tree.add(v);
            }
        });

        return convertTree(tree, menuVoList.stream().filter(v -> !v.getParentId().equals("0")).toList());
    }

    private List<MenuVo> convertTree(List<MenuVo> tree, List<MenuVo> menuVoList) {
        menuVoList.forEach(v -> {
            tree.forEach(t -> {
                if (t.getId().equals(v.getParentId())) {
                    if (t.getChildren() == null) {
                        t.setChildren(new ArrayList<>());
                    }
                    t.getChildren().add(v);
                    menuVoList.remove(v);
                }
            });
        });
        if (menuVoList.size() > 0) {
            convertTree(tree, menuVoList);
        }
        return tree;
    }

    @Override
    public List<MenuVo> roleTree(String roleId) {
        return null;
    }

    @Override
    public boolean checkMenuName(String name) {
        return Objects.nonNull(menuMapper.selectOne(new LambdaQueryWrapper<Menu>()
                .eq(Menu::getName, name)));
    }

    @Override
    public boolean checkChildMenu(String id) {
        return menuMapper.selectList(new LambdaQueryWrapper<Menu>()
                .eq(Menu::getParentId, id)).size() > 0;
    }

    @Override
    public boolean checkRoleMenu(String id) {
        return roleMenuMapper.selectList(new LambdaQueryWrapper<RoleMenu>()
                .eq(RoleMenu::getMenuId, id)).size() > 0;
    }

    @Override
    public boolean checkMenuName(String name, String id) {
        return Objects.nonNull(menuMapper.selectOne(new LambdaQueryWrapper<Menu>()
                .eq(Menu::getName, name)
                .ne(Menu::getId, id)));
    }

    @Override
    public int insert(Menu menu) {
        return menuMapper.insert(menu);
    }

    @Override
    public int delete(String id) {
        return menuMapper.deleteById(id);
    }

    @Override
    public int update(Menu menu) {
        return menuMapper.updateById(menu);
    }
}
