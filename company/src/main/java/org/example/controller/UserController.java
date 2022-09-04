package org.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.entity.User;
import org.example.entity.vo.UserParam;
import org.example.key.CommodityKey;
import org.example.model.PageR;
import org.example.model.R;
import org.example.result.CompareExecute;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询用户")
    @GetMapping("/select")
    public PageR<List<User>> select(UserParam userParam) {
        IPage<User> userIPage = userService.selectListByPage(userParam);
        return new PageR<List<User>>()
                .ok(userIPage.getRecords())
                .setCount(userIPage.getTotal());
    }


    @ApiOperation(value = "修改用户")
    @PutMapping("/update")
    public R<String> update(User user) {
        return new CompareExecute<String>()
                .compare(userService.update(user), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "修改用户可用")
    @PostMapping(value = "/status/on")
    public R<String> publishStatusOn(String id) {
        return new CompareExecute<>().compare(userService.update(
                new User()
                        .setStatus(1)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "修改用户禁用")
    @PostMapping(value = "/status/off")
    public R<String> publishStatusOff(String id) {
        return new CompareExecute<>().compare(userService.update(
                new User()
                        .setStatus(0)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "修改用户删除")
    @PostMapping(value = "/delete/status/on")
    public R<String> deleteStatusOn(String id) {
        return new CompareExecute<>().compare(userService.update(
                (User) new User()
                        .setDeleteStatus(1)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }

    @ApiOperation(value = "修改用户 not 删除")
    @PostMapping(value = "/delete/status/off")
    public R<String> deleteStatusOff(String id) {
        return new CompareExecute<>().compare(userService.update(
                (User) new User()
                        .setDeleteStatus(0)
                        .setId(id)
        ), CompareExecute.ExecuteStatus.UPDATE);
    }

}
