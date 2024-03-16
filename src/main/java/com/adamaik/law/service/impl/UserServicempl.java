package com.adamaik.law.service.impl;

import com.adamaik.law.mapper.UserMapper;
import com.adamaik.law.pojo.User;
import com.adamaik.law.service.UserService;
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
}
