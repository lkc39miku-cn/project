package org.example.service;

import org.example.entity.Menu;
import org.example.entity.vo.MenuVo;

import java.util.List;
import java.util.Set;

public interface MenuService {
    Set<String> selectMenuPermsByStaffId(String id);

    MenuVo selectByPrimaryKey(String id);

    List<MenuVo> selectList(Menu menu);

    List<MenuVo> tree(List<MenuVo> menuVoList);

    List<MenuVo> roleTree(String roleId);

    boolean checkMenuName(String name);

    boolean checkChildMenu(String id);

    boolean checkRoleMenu(String id);

    boolean checkMenuName(String name, String id);


    int insert(Menu menu);

    int delete(String id);


    int update(Menu menu);

}
