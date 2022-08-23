package org.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.entity.Post;
import org.example.entity.Role;
import org.example.entity.convert.RoleConvert;
import org.example.entity.param.RoleParam;
import org.example.entity.vo.RoleVo;
import org.example.model.PageR;
import org.example.model.R;
import org.example.result.CompareExecute;
import org.example.result.ServiceExecute;
import org.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/role")
@Api(tags = "角色Api")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleConvert roleConvert;

    @GetMapping("select/{id}")
    @ApiOperation(value = "通过主键查询单条数据", notes = "通过主键查询单条数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:role:query')")
    public R<RoleVo> selectOne(@PathVariable(value = "id") String id) {
        return new R<RoleVo>().ok(roleService.selectByPrimaryKey(id));
    }

    @GetMapping("select")
    @ApiOperation(value = "查询所有数据", notes = "查询所有数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:role:list')")
    public PageR<List<RoleVo>> selectList(RoleParam roleParam) {
        IPage<Role> postIPage = roleService.selectListByPage(roleParam);
        return new PageR<List<RoleVo>>().ok(roleConvert.convert(postIPage.getRecords()))
                .setCount(postIPage.getTotal());
    }

    @PostMapping("insert")
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
}
