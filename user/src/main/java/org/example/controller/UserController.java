package org.example.controller;

import io.swagger.annotations.Api;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(tags = "用户")
public class UserController {
    @Autowired
    private UserService userService;
}
