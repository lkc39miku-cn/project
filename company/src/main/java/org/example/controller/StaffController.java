package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.entity.vo.StaffVo;
import org.example.model.R;
import org.example.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
@Api(tags = "员工Api")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @GetMapping("select/{id}")
    @ApiOperation(value = "通过主键查询单条数据", notes = "通过主键查询单条数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:staff:query')")
    public R<StaffVo> selectOne(@PathVariable(value = "id") String id) {
        return new R<StaffVo>().ok(staffService.selectByPrimaryKey(id));
    }
}
