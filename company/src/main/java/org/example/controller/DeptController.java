package org.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.example.config.GlobalFallback;
import org.example.entity.Dept;
import org.example.entity.vo.DeptVo;
import org.example.key.DeptKey;
import org.example.model.R;
import org.example.result.CompareExecute;
import org.example.service.DeptService;
import org.example.util.RedisCache;
import org.example.util.StaffThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/dept")
@Api(tags = "部门Api")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @Autowired
    private RedisCache redisCache;

    @GetMapping("/select/{id}")
    @ApiOperation(value = "通过主键查询单条数据", notes = "通过主键查询单条数据")
    @SentinelResource(value = "/dept/select/{id}", fallbackClass = GlobalFallback.class, defaultFallback = "handleException")
    @PreAuthorize("@permissionCheck.hasPermissions('system:dept:query')")
    public R<DeptVo> selectOne(@PathVariable(value = "id") String id) {
        DeptVo deptVo = Objects.isNull(redisCache.getCacheObject(DeptKey.REDIS_SELECT_ID_KEY + id)) ?
                deptService.selectByPrimaryKey(id) : (DeptVo) redisCache.getCacheObject(DeptKey.REDIS_SELECT_ID_KEY + id);
        return new R<DeptVo>()
                .ok(deptVo);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "新增数据", notes = "新增数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:dept:add')")
    public R<String> insert(@RequestBody Dept dept) {
        if (deptService.checkDeptNameUnique(dept.getName())) {
            return new R<String>().fail("新增部门'" + dept.getName() + "'失败，部门名称已存在");
        }
        dept.setCreateStaffId(StaffThreadLocal.getStaff().getId());
        redisCache.deleteObject(DeptKey.REDIS_SELECT_ALL);
        redisCache.deleteObject(DeptKey.REDIS_TREE);
        return new CompareExecute<>().compare(deptService.insert(dept), CompareExecute.ExecuteStatus.INSERT);
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改数据", notes = "修改数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:dept:edit')")
    public R<String> update(@RequestBody Dept dept) {
        if (deptService.checkDeptNameUnique(dept.getName(), dept.getId())) {
            return new R<String>().fail("修改部门'" + dept.getName() + "'失败，部门名称已存在");
        }
        if (dept.getParentId().equals(dept.getId())) {
            return new R<String>().fail("修改部门'" + dept.getName() + "'失败，上级部门不能为自己");
        }
        if (DeptKey.IS_NOT_USED.equals(dept.getStatus()) && deptService.selectOnlineChildrenByParentId(dept.getId())) {
            return new R<String>().fail("修改部门'" + dept.getName() + "'失败，存在子部门在线状态");
        }
        redisCache.deleteObject(DeptKey.REDIS_SELECT_ID_KEY + dept.getId());
        redisCache.deleteObject(DeptKey.REDIS_SELECT_ALL);
        redisCache.deleteObject(DeptKey.REDIS_TREE);
        return new CompareExecute<>().compare(deptService.update(dept), CompareExecute.ExecuteStatus.UPDATE);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除数据", notes = "删除数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:dept:delete')")
    public R<String> delete(@PathVariable(value = "id") String id) {
        if (deptService.hasChildByParentId(id)) {
            return new R<String>().fail("删除部门失败，当前部门存在下级部门");
        }
        if (deptService.checkExistStaffByDeptId(id)) {
            return new R<String>().fail("删除部门失败，当前部门存在员工");
        }
        redisCache.deleteObject(DeptKey.REDIS_SELECT_ID_KEY + id);
        redisCache.deleteObject(DeptKey.REDIS_SELECT_ALL);
        redisCache.deleteObject(DeptKey.REDIS_TREE);
        return new CompareExecute<>().compare(deptService.delete(id), CompareExecute.ExecuteStatus.DELETE);
    }

    @GetMapping("/select/exclude/{id}")
    @ApiOperation(value = "排除指定节点", notes = "排除指定节点")
    @PreAuthorize("@permissionCheck.hasPermissions('system:dept:list')")
    public R<List<DeptVo>> selectExclude(@PathVariable(value = "id") String id) {
        List<DeptVo> deptVoList = redisCache.getCacheList(DeptKey.REDIS_SELECT_ALL).isEmpty() ?
                deptService.selectAll() : redisCache.getCacheList(DeptKey.REDIS_SELECT_ALL);
        deptVoList.removeIf(v -> v.getId().equals(id)
                || ArrayUtils.contains(StringUtils.split(v.getAncestors(), ","), id));
        return new R<List<DeptVo>>().ok(deptVoList);
    }

    @GetMapping("/tree")
    @ApiOperation(value = "树形结构", notes = "树形结构")
    @PreAuthorize("@permissionCheck.hasPermissions('system:dept:list')")
    public R<List<DeptVo>> tree() {
        List<DeptVo> tree;
        if (redisCache.getCacheList(DeptKey.REDIS_TREE).isEmpty()) {
            tree = deptService.tree(deptService.selectList(new Dept().setStatus(DeptKey.IS_USED).setDeleteStatus(DeptKey.IS_NOT_DELETE)));
            redisCache.setCacheList(DeptKey.REDIS_TREE, tree);
        } else {
            tree = redisCache.getCacheObject(DeptKey.REDIS_TREE);
        }
        return new R<List<DeptVo>>().ok(tree);
    }

    @GetMapping("/role/tree/{roleId}")
    @ApiOperation(value = "加载对应角色部门列表树", notes = "加载对应角色部门列表树")
    @PreAuthorize("@permissionCheck.hasPermissions('system:dept:list')")
    public R<List<DeptVo>> roleTree(@PathVariable(value = "roleId") String roleId) {
        return new R<List<DeptVo>>().ok(deptService.roleTree(roleId));
    }
}
