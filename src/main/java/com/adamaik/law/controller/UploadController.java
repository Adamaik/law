package com.adamaik.law.controller;

import com.adamaik.law.pojo.Result;
import com.adamaik.law.pojo.User;
import com.adamaik.law.service.FileService;
import com.adamaik.law.service.PermissionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Adamaik
 */
@Slf4j
@RestController
public class UploadController {
    //保存路径，根据系统修改配置
    private final String savePath = "D:\\article\\";
    @Autowired
    private FileService fileService;
    @Autowired
    private PermissionUtils permissionUtils;
    @PostMapping("/upload")
    public Result upload(Integer flag,String title, MultipartFile file,@RequestHeader("token")String token) throws IOException {
        final Integer permission = 1; //该接口所需权限设置
        User temp = permissionUtils.getPermission(token);
        if(temp.getPermission() > permission){
            return Result.error("权限不足");
        }
        log.info("文件上传:{},{},{}",title,file,flag);
        //将临时文件转存为本地存储
        //UUID生成唯一id，防止文件互相覆盖
        int index=file.getOriginalFilename().lastIndexOf(".");
        String path;
        if(index==-1){
            path=savePath+ UUID.randomUUID();
        }
        else {
            path = savePath + UUID.randomUUID() + file.getOriginalFilename().substring(index);
        }
        file.transferTo(new File(path));
        fileService.addFilePath(flag,title,temp,path);
        return Result.success();
    }
}
