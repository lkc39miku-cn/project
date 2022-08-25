package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.entity.Menu;
import org.example.entity.vo.MenuVo;
import org.example.key.MenuKey;
import org.example.model.R;
import org.example.result.CompareExecute;
import org.example.service.MenuService;
import org.example.util.IpUtils;
import org.example.util.StaffThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
@Api(tags = "菜单Api")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/select/{id}")
    @ApiOperation(value = "通过主键查询单条数据", notes = "通过主键查询单条数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:menu:query')")
    public R<MenuVo> selectOne(@PathVariable(value = "id") String id) {
        return new R<MenuVo>().ok(menuService.selectByPrimaryKey(id));
    }

    @PostMapping("/insert")
    @ApiOperation(value = "新增数据", notes = "新增数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:menu:add')")
    public R<String> insert(@RequestBody Menu menu) {
        if (menuService.checkMenuName(menu.getName())) {
            return new R<String>().fail("菜单名称已存在");
        }
        if (MenuKey.IS_FRAME.equals(menu.getIsFrame()) && !IpUtils.isHttp(menu.getPath())) {
            return new R<String>().fail("非http协议的链接必须是http或https开头");
        }
        menu.setCreateStaffId(StaffThreadLocal.getStaff().getId());
        return new CompareExecute<>().compare(menuService.insert(menu), CompareExecute.ExecuteStatus.INSERT);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除数据", notes = "删除数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:menu:delete')")
    public R<String> delete(@PathVariable(value = "id") String id) {
        if (menuService.checkChildMenu(id)) {
            return new R<String>().fail("该菜单下存在子菜单，不能删除");
        }
        if (menuService.checkRoleMenu(id)) {
            return new R<String>().fail("该菜单下存在角色，不能删除");
        }
        return new CompareExecute<>().compare(menuService.delete(id), CompareExecute.ExecuteStatus.DELETE);
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改数据", notes = "修改数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:menu:update')")
    public R<String> update(@RequestBody Menu menu) {
        if (menuService.checkMenuName(menu.getName(), menu.getId())) {
            return new R<String>().fail("菜单名称已存在");
        }
        if (MenuKey.IS_FRAME.equals(menu.getIsFrame()) && !IpUtils.isHttp(menu.getPath())) {
            return new R<String>().fail("非http协议的链接必须是http或https开头");
        }
        if (menu.getParentId().equals(menu.getId())) {
            return new R<String>().fail("上级菜单不能为自身");
        }
        return new CompareExecute<>().compare(menuService.update(menu), CompareExecute.ExecuteStatus.UPDATE);
    }

    @GetMapping("/tree")
    @ApiOperation(value = "树形菜单", notes = "树形菜单")
    @PreAuthorize("@permissionCheck.hasPermissions('system:menu:list')")
    public R<List<MenuVo>> tree() {
        return new R<List<MenuVo>>().ok(menuService.tree(menuService.selectList(new Menu().setVisible(MenuKey.IS_SHOW)
                .setStatus(MenuKey.IS_USED))));
    }

    @GetMapping("/role/tree/{roleId}")
    @ApiOperation(value = "加载对应角色菜单列表树", notes = "加载对应角色菜单列表树")
    @PreAuthorize("@permissionCheck.hasPermissions('system:menu:list')")
    public R<List<MenuVo>> roleTree(@PathVariable(value = "roleId") String roleId) {
        return new R<List<MenuVo>>().ok(menuService.roleTree(roleId));
    }
}
