package com.adamaik.law.service.impl;

import com.adamaik.law.mapper.UserMapper;
import com.adamaik.law.pojo.User;
import com.adamaik.law.service.PermissionUtils;
import com.adamaik.law.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Adamaik
 */
@Slf4j
@Service
public class PermissionUtilsmpl implements PermissionUtils {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getPermission(String token) {
        Integer id;
        try{
            id = JwtUtils.parseJWT(token).get("id",Integer.class);
        }
        catch (Exception e){
            log.info("令牌id信息缺失");
            throw e;
        }
        return userMapper.getById(id);
    }
}
