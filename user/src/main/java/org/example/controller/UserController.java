package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.entity.User;
import org.example.model.R;
import org.example.result.CompareExecute;
import org.example.service.UserService;
import org.example.util.UserThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(tags = "用户")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户信息")
    @GetMapping("/info")
    public R<User> info() {
        return new R<User>()
                .ok(UserThreadLocal.getUser());
    }

    @ApiOperation(value = "修改个人信息")
    @PutMapping("/update")
    public R<String> update(User user) {
        return new CompareExecute<String>()
                .compare(userService.update(user
                        .setId(UserThreadLocal.getUser().getId())), CompareExecute.ExecuteStatus.INSERT);
    }

    @ApiOperation(value = "修改密码")
    @PutMapping("/updatePassword")
    public R<String> updatePassword(String oldPassword, String newPassword) {
        return new CompareExecute<String>()
                .compare(userService.updatePassword(oldPassword, newPassword), CompareExecute.ExecuteStatus.UPDATE);
    }
}
