package com.adamaik.law.mapper;

import com.adamaik.law.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


/**
 * @author Adamaik
 */
@Mapper
public interface UserMapper {
    /**
     * 根据账户，密码查询
     */
    @Select("select * from law.employee where account=#{account} and password=#{password}")
    User getByUsernameAndPassword(User user);

    @Select("select * from law.employee where id=#{id}")
    User getById(Integer id);
}
