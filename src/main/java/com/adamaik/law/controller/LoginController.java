package com.adamaik.law.controller;


import com.adamaik.law.pojo.Result;
import com.adamaik.law.pojo.User;
import com.adamaik.law.service.UserService;
import lombok.extern.slf4j.Slf4j;
import com.adamaik.law.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Adamaik
 */
@RestController
@Slf4j
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;
    /**
     * 登录功能
     */
    @PostMapping
    public Result login(@RequestBody User user){
        log.info("员工{}登录",user.getName());
        User e=userService.login(user);
        //老方法，不返回twp令牌
        //return e==null?Result.error("用户名或密码错误"):Result.success();
        //新方法
        if(e!=null){
            Map<String,Object> claims=new HashMap<>();
            claims.put("id",e.getId());
            claims.put("name",e.getName());
            claims.put("account",e.getAccount());
            String jwt= JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        else{
            return Result.error("用户名或密码错误");
        }
    }

}
