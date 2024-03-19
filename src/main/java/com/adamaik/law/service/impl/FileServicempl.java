package com.adamaik.law.service.impl;

import com.adamaik.law.mapper.FileMapper;
import com.adamaik.law.pojo.User;
import com.adamaik.law.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Adamaik
 */
@Slf4j
@Service
public class FileServicempl implements FileService {
    @Autowired
    private FileMapper fileMapper;
    @Override
    public void addFilePath(Integer flag,String title,User user, String path) {
        fileMapper.insert(flag,title,user.getId(),path);
    }
}
