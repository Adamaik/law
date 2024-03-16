package com.adamaik.law.controller;

import com.adamaik.law.pojo.Result;
import com.adamaik.law.service.PermissionUtils;
import com.adamaik.law.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Adamaik
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class EmployeeController {
    @Autowired
    private PermissionUtils permissionUtils;
    @Autowired
    private UserService userService;
    @GetMapping()
    Result getAccountMessage(@RequestHeader("token")String token){
        return Result.success(userService.getAccoutMessage(token));
    }
}
