package com.adamaik.law.service.impl;

import com.adamaik.law.mapper.UserMapper;
import com.adamaik.law.pojo.User;
import com.adamaik.law.service.UserService;
import com.adamaik.law.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  @author Adamaik
 */
@Service
@Slf4j
public class UserServicempl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.getByUsernameAndPassword(user);
    }

    @Override
    public User getAccoutMessage(String token) {
        Integer id;
        try{
            id = JwtUtils.parseJWT(token).get("id",Integer.class);
        }
        catch (Exception e){
            log.info("令牌id信息缺失");
            log.info(token);
            throw e;
        }
        User user = userMapper.getById(id);
        user.setPassword("");
        user.setId(null);
        return user;
    }
}
