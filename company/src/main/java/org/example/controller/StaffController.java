package org.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.entity.Staff;
import org.example.entity.convert.StaffConvert;
import org.example.entity.param.StaffParam;
import org.example.entity.vo.StaffVo;
import org.example.model.PageR;
import org.example.model.R;
import org.example.result.CompareExecute;
import org.example.service.StaffService;
import org.example.util.SecurityUtils;
import org.example.util.StaffThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/staff")
@Api(tags = "员工Api")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private StaffConvert staffConvert;

    @GetMapping("/select/{id}")
    @ApiOperation(value = "通过主键查询单条数据", notes = "通过主键查询单条数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:staff:query')")
    public R<StaffVo> selectOne(@PathVariable(value = "id") String id) {
        return new R<StaffVo>().ok(staffService.selectByPrimaryKey(id));
    }

    @GetMapping("/select")
    @ApiOperation(value = "查询数据", notes = "查询数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:staff:list')")
    public PageR<List<StaffVo>> selectList(StaffParam staffParam) {
        IPage<Staff> staffIPage = staffService.selectListByPage(staffParam);
        return new PageR<List<StaffVo>>().ok(staffConvert.convert(staffIPage.getRecords()))
                .setCount(staffIPage.getTotal());
    }

    @PostMapping("/insert")
    @ApiOperation(value = "添加数据", notes = "添加数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:staff:add')")
    public R<String> insert(@RequestBody Staff staff) {
        if (staffService.checkStaffUsername(staff.getUsername())) {
            return new R<String>().fail("用户名已存在");
        }
        if (staffService.checkStaffPhone(staff.getPhone())) {
            return new R<String>().fail("手机号已存在");
        }
        if (staffService.checkStaffEmail(staff.getEmail())) {
            return new R<String>().fail("邮箱已存在");
        }
        staff.setCreateStaffId(StaffThreadLocal.getStaff().getId());
        return new CompareExecute<>().compare(staffService.insert(staff), CompareExecute.ExecuteStatus.INSERT);
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改数据", notes = "修改数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:staff:edit')")
    public R<String> update(@RequestBody Staff staff) {
        staffService.checkStaffAllowed(staff);
        if (staffService.checkStaffUsername(staff.getUsername(), staff.getId())) {
            return new R<String>().fail("用户名已存在");
        }
        if (staffService.checkStaffPhone(staff.getPhone(), staff.getId())) {
            return new R<String>().fail("手机号已存在");
        }
        if (staffService.checkStaffEmail(staff.getEmail(), staff.getId())) {
            return new R<String>().fail("邮箱已存在");
        }
        return new CompareExecute<>().compare(staffService.update(staff), CompareExecute.ExecuteStatus.UPDATE);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除数据", notes = "删除数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:staff:delete')")
    public R<String> delete(@PathVariable(value = "id") String id) {
        staffService.checkStaffAllowed((Staff) new Staff().setId(id));
        return new CompareExecute<>().compare(staffService.delete(id), CompareExecute.ExecuteStatus.DELETE);
    }

    @PutMapping("/update/password")
    @ApiOperation(value = "修改密码", notes = "修改密码")
    @PreAuthorize("@permissionCheck.hasPermissions('system:staff:edit')")
    public R<String> updatePassword(@RequestBody Staff staff) {
        staffService.checkStaffAllowed(staff);
        staff.setPassword(SecurityUtils.encryptPassword(staff.getPassword()));
        return new CompareExecute<>().compare(staffService.update((Staff) new Staff()
                .setPassword(staff.getPassword())
                .setId(staff.getId())), CompareExecute.ExecuteStatus.UPDATE);
    }

    @PutMapping("/update/status")
    @ApiOperation(value = "状态修改", notes = "状态修改")
    @PreAuthorize("@permissionCheck.hasPermissions('system:staff:edit')")
    public R<String> updateStatus(@RequestBody Staff staff) {
        staffService.checkStaffAllowed(staff);
        return new CompareExecute<>().compare(staffService.update((Staff) new Staff()
                .setStatus(staff.getStatus())
                .setId(staff.getId())), CompareExecute.ExecuteStatus.UPDATE);
    }

    @GetMapping("/get/role/{id}")
    @ApiOperation(value = "获取已授权角色", notes = "获取已授权角色")
    @PreAuthorize("@permissionCheck.hasPermissions('system:staff:list')")
    public R<StaffVo> getRole(@PathVariable(value = "id") String id) {
        return new R<StaffVo>().ok(staffService.selectByPrimaryKey(id));
    }

    @PutMapping("/update/role")
    @ApiOperation(value = "授权角色", notes = "授权角色")
    @PreAuthorize("@permissionCheck.hasPermissions('system:staff:edit')")
    public R<String> updateRole(@RequestBody StaffParam staffParam) {
        return new CompareExecute<>().compare(staffService.updateRole(staffParam.getId(), staffParam.getRoleIdList()), staffParam.getRoleIdList().size(), CompareExecute.ExecuteStatus.UPDATE);
    }
}
