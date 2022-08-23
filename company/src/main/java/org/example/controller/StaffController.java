package org.example.controller;

import io.swagger.annotations.Api;
import org.example.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
@Api(tags = "员工Api")
public class StaffController {
    @Autowired
    private StaffService staffService;
}
