package com.adamaik.law.service;

import com.adamaik.law.pojo.User;

/**
 * @author Adamaik
 */
public interface UserService {
    User login(User input);
    User getAccoutMessage(String token);
}
