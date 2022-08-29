package org.example.controller;



import com.baomidou.mybatisplus.core.metadata.IPage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.entity.Song;
import org.example.entity.User;
import org.example.entity.param.UserParam;
import org.example.entity.vo.SongVo;
import org.example.model.PageR;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用户表(User)表控制层
 *
 * @author makejava
 * @since 2022-08-26 19:30:39
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController  {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;
    /**
     * 分页查询所有数据
     *
     * @param userParam 查询实体
     * @return 所有数据
     */
    @GetMapping("/selectAll")
    @ApiOperation(value = "所有用户信息分页查询",notes = "所有用户信息分页查询")
    public PageR<List<User>> selectAll(@RequestBody UserParam userParam) {
        IPage<User> userIPage = userService.selectByParam(userParam);
        return new PageR<List<User>>().ok(userIPage.getRecords())
                .setCount(userIPage.getTotal());
    }

    /**
     * 通过主键查询单条数据
//     *
//     * @param id 主键
//     * @return 单条数据
//     */
//    @GetMapping("{id}")
//    public R selectOne(@PathVariable Serializable id) {
//        return success(this.userService.getById(id));
//    }
//
//    /**
//     * 新增数据
//     *
//     * @param user 实体对象
//     * @return 新增结果
//     */
//    @PostMapping
//    public R insert(@RequestBody User user) {
//        return success(this.userService.save(user));
//    }
//
//    /**
//     * 修改数据
//     *
//     * @param user 实体对象
//     * @return 修改结果
//     */
//    @PutMapping
//    public R update(@RequestBody User user) {
//        return success(this.userService.updateById(user));
//    }
//
//    /**
//     * 删除数据
//     *
//     * @param idList 主键结合
//     * @return 删除结果
//     */
//    @DeleteMapping
//    public R delete(@RequestParam("idList") List<Long> idList) {
//        return success(this.userService.removeByIds(idList));
//    }
}

