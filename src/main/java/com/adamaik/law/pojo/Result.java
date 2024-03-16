package com.adamaik.law.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Adamaik
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code;//响应码，1代表成功；0代表失败
    private String msg;//响应信息，描述字符串
    private Object data;//返回的数据
    //增删改的成功响应
    public static Result success(){
        return new Result(1,"success",null);
    }
    //查的成功响应
    public static Result success(Object data){
        return new Result(1,"success",data);
    }
    //失败响应
    public static Result error(String msg){
        return new Result(0,msg,null);
    }
}
