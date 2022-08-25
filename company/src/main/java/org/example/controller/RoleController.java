package org.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.entity.Post;
import org.example.entity.Role;
import org.example.entity.Staff;
import org.example.entity.StaffRole;
import org.example.entity.convert.RoleConvert;
import org.example.entity.convert.StaffConvert;
import org.example.entity.param.RoleParam;
import org.example.entity.param.StaffParam;
import org.example.entity.vo.RoleVo;
import org.example.entity.vo.StaffVo;
import org.example.key.RoleKey;
import org.example.mapper.StaffMapper;
import org.example.model.PageR;
import org.example.model.R;
import org.example.result.CompareExecute;
import org.example.result.ServiceExecute;
import org.example.service.MenuService;
import org.example.service.RoleService;
import org.example.util.StaffThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping("/role")
@Api(tags = "角色Api")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleConvert roleConvert;
    @Autowired
    private StaffConvert staffConvert;

    @GetMapping("/select/{id}")
    @ApiOperation(value = "通过主键查询单条数据", notes = "通过主键查询单条数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:role:query')")
    public R<RoleVo> selectOne(@PathVariable(value = "id") String id) {
        return new R<RoleVo>().ok(roleService.selectByPrimaryKey(id));
    }

    @GetMapping("/select")
    @ApiOperation(value = "查询所有数据", notes = "查询所有数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:role:list')")
    public PageR<List<RoleVo>> selectList(RoleParam roleParam) {
        IPage<Role> postIPage = roleService.selectListByPage(roleParam);
        return new PageR<List<RoleVo>>().ok(roleConvert.convert(postIPage.getRecords()))
                .setCount(postIPage.getTotal());
    }

    @PostMapping("/insert")
    @ApiOperation(value = "新增数据", notes = "新增数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:role:add')")
    public R<String> insert(@RequestBody Role role) {
        if (roleService.checkName(role.getName())) {
            return new R<String>().fail("角色名称已存在");
        }
        if (roleService.checkRoleKey(role.getRoleKey())) {
            return new R<String>().fail("角色标识已存在");
        }
        return new CompareExecute<>().compare(roleService.insert(role), CompareExecute.ExecuteStatus.INSERT);
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改数据", notes = "修改数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:role:edit')")
    public R<String> update(@RequestBody Role role) {
        roleService.checkRoleAllowed(role);
        if (roleService.checkName(role.getName(), role.getId())) {
            return new R<String>().fail("角色名称已存在");
        }
        if (roleService.checkRoleKey(role.getRoleKey(), role.getId())) {
            return new R<String>().fail("角色标识已存在");
        }

        ServiceExecute.compare(roleService.update(role), ServiceExecute.ExecuteStatus.UPDATE);
        Staff staff = StaffThreadLocal.getStaff();
        if (Objects.nonNull(staff) && !staff.isAdmin()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            List<GrantedAuthority> authorities = new ArrayList<>();
            Set<String> perms = menuService.selectMenuPermsByStaffId(staff.getId());
            perms.forEach(v -> {
                authorities.add(new SimpleGrantedAuthority(v));
            });

            Authentication newAuth = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), authorities);
            SecurityContextHolder.getContext().setAuthentication(newAuth);
        }
        return new R<String>().ok();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除数据", notes = "删除数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:role:delete')")
    public R<String> delete(@PathVariable(value = "id") String id) {
        roleService.checkRoleAllowed((Role) new Role().setId(id));
        return new CompareExecute<>().compare(roleService.delete(id), CompareExecute.ExecuteStatus.DELETE);
    }

    @PutMapping("/update/permission")
    @ApiOperation(value = "修改保存数据权限", notes = "修改保存数据权限")
    @PreAuthorize("@permissionCheck.hasPermissions('system:role:edit')")
    public R<String> updatePermission(@RequestBody RoleParam roleParam) {
        roleService.checkRoleAllowed((Role) new Role().setId(roleParam.getId()));
        return new CompareExecute<>().compare(roleService.authDataScope(roleParam), roleParam.getDeptIdList().size(), CompareExecute.ExecuteStatus.UPDATE);
    }

    @PutMapping("/update/status")
    @ApiOperation(value = "状态修改", notes = "状态修改")
    @PreAuthorize("@permissionCheck.hasPermissions('system:role:edit')")
    public R<String> updateStatus(@RequestBody Role role) {
        roleService.checkRoleAllowed(role);
        return new CompareExecute<>().compare(roleService.update((Role) new Role()
                .setStatus(role.getStatus())
                .setId(role.getId())), CompareExecute.ExecuteStatus.UPDATE);
    }

    @GetMapping("/select/select")
    @ApiOperation(value = "获取角色选择框列表", notes = "获取角色选择框列表")
    @PreAuthorize("@permissionCheck.hasPermissions('system:role:list')")
    public R<List<RoleVo>> selectSelect() {
        return new R<List<RoleVo>>().ok(roleService.selectList(new RoleParam()
                .setDeleteStatus(RoleKey.IS_NOT_DELETE)
                .setStatus(RoleKey.IS_USED)));
    }

    @GetMapping("/select/assigned")
    @ApiOperation(value = "已分配用户角色列表", notes = "已分配用户角色列表")
    @PreAuthorize("@permissionCheck.hasPermissions('system:role:list')")
    public PageR<List<StaffVo>> selectAssigned(@RequestBody StaffParam staffParam) {
        IPage<Staff> staffIPage = roleService.selectAssigned(staffParam);
        return new PageR<List<StaffVo>>().ok(staffConvert.convert(staffIPage.getRecords()))
                .setCount(staffIPage.getTotal());
    }

    @GetMapping("/select/unassigned")
    @ApiOperation(value = "已分配用户角色列表", notes = "已分配用户角色列表")
    @PreAuthorize("@permissionCheck.hasPermissions('system:role:list')")
    public PageR<List<StaffVo>> selectUnAssigned(@RequestBody StaffParam staffParam) {
        IPage<Staff> staffIPage = roleService.selectUnAssigned(staffParam);
        return new PageR<List<StaffVo>>().ok(staffConvert.convert(staffIPage.getRecords()))
                .setCount(staffIPage.getTotal());
    }

    @PutMapping("/cancel/assign")
    @ApiOperation(value = "取消授权用户", notes = "取消授权用户")
    @PreAuthorize("@permissionCheck.hasPermissions('system:role:edit')")
    public R<String> cancelAssign(@RequestBody StaffRole staffRole) {
        return new CompareExecute<>().compare(roleService.cancelAssign(staffRole), CompareExecute.ExecuteStatus.UPDATE);
    }

    @PutMapping("/cancel/assign/batch")
    @ApiOperation(value = "批量取消授权用户", notes = "批量取消授权用户")
    @PreAuthorize("@permissionCheck.hasPermissions('system:role:edit')")
    public R<String> cancelAssignBatch(@RequestBody RoleParam roleParam) {
        return new CompareExecute<>().compare(roleService.cancelAssignBatch(roleParam.getId(), roleParam.getStaffIdList()), roleParam.getStaffIdList().size(), CompareExecute.ExecuteStatus.UPDATE);
    }

    @PutMapping("/assign/batch")
    @ApiOperation(value = "批量选择用户授权", notes = "批量选择用户授权")
    @PreAuthorize("@permissionCheck.hasPermissions('system:role:edit')")
    public R<String> assignBatch(@RequestBody RoleParam roleParam) {
        return new CompareExecute<>().compare(roleService.assignBatch(roleParam.getId(), roleParam.getStaffIdList()), roleParam.getStaffIdList().size(), CompareExecute.ExecuteStatus.UPDATE);
    }
}
