package org.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.entity.Post;
import org.example.entity.convert.PostConvert;
import org.example.entity.param.PostParam;
import org.example.entity.vo.PostVo;
import org.example.model.PageR;
import org.example.model.R;
import org.example.result.CompareExecute;
import org.example.service.PostService;
import org.example.util.StaffThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@Api(tags = "岗位Api")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private PostConvert postConvert;

    @GetMapping("/select/{id}")
    @ApiOperation(value = "通过主键查询单条数据", notes = "通过主键查询单条数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:post:query')")
    public R<PostVo> selectOne(@PathVariable(value = "id") String id) {
        return new R<PostVo>().ok(postService.selectByPrimaryKey(id));
    }

    @GetMapping("/select")
    @ApiOperation(value = "查询所有数据", notes = "查询所有数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:post:list')")
    public PageR<List<PostVo>> selectList(PostParam postParam) {
        IPage<Post> postIPage = postService.selectListByPage(postParam);
        return new PageR<List<PostVo>>().ok(postConvert.convert(postIPage.getRecords()))
                .setCount(postIPage.getTotal());
    }

    @GetMapping("/select/all")
    @ApiOperation(value = "选择框", notes = "选择框")
    @PreAuthorize("@permissionCheck.hasPermissions('system:post:list')")
    public R<List<PostVo>> selectBox() {
        return new R<List<PostVo>>().ok(postService.selectAll());
    }

    @PostMapping("/insert")
    @ApiOperation(value = "添加数据", notes = "添加数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:post:add')")
    public R<String> insert(Post post) {
        if (postService.checkPostName(post.getName())) {
            return new R<String>().fail("岗位名称已存在");
        }
        if (postService.checkPostCode(post.getCode())) {
            return new R<String>().fail("岗位编码已存在");
        }
        post.setCreateStaffId(StaffThreadLocal.getStaff().getId());
        return new CompareExecute<>().compare(postService.insert(post), CompareExecute.ExecuteStatus.INSERT);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除数据", notes = "删除数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:post:delete')")
    public R<String> delete(@PathVariable(value = "id") String id) {
        if (postService.checkStaffPost(id)) {
            return new R<String>().fail("该岗位已被使用，不能删除");
        }
        return new CompareExecute<>().compare(postService.delete(id), CompareExecute.ExecuteStatus.DELETE);
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新数据", notes = "更新数据")
    @PreAuthorize("@permissionCheck.hasPermissions('system:post:update')")
    public R<String> update(Post post) {
        if (postService.checkPostName(post.getName(), post.getId())) {
            return new R<String>().fail("岗位名称已存在");
        }
        if (postService.checkPostCode(post.getCode(), post.getId())) {
            return new R<String>().fail("岗位编码已存在");
        }
        return new CompareExecute<>().compare(postService.update(post), CompareExecute.ExecuteStatus.UPDATE);
    }
}
