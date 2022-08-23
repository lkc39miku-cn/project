package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.Staff;
import org.example.key.PermissionKey;
import org.example.service.MenuService;
import org.example.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private MenuService menuService;

    @Override
    public Set<String> getMenuPermission(Staff staff) {
        Set<String> menuList = new HashSet<>(10);
        if (staff.isAdmin()) {
            menuList.add(PermissionKey.ALL_PERMISSION);
        } else {
            menuList.addAll(menuService.selectMenuPermsByStaffId(staff.getId()));
        }

        log.info("用户权限：{}", menuList);
        return menuList;
    }
}
