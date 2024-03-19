package com.adamaik.law.service;


import com.adamaik.law.pojo.User;

public interface PermissionUtils {
    User getPermission(String token);
}
