package com.adamaik.law.service;

import com.adamaik.law.pojo.User;

/**
 * @author Adamaik
 */
public interface FileService {
    void addFilePath(Integer flag,String title,User user, String path);

}
