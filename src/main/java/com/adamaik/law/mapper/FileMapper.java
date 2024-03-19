package com.adamaik.law.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Adamaik
 */
@Mapper
public interface FileMapper {
    @Insert("insert into law.article(title, author_id, storage_path,flag) values (#{id},#{title},#{path},#{flag})")
    void insert( @Param("flag") Integer flag,@Param("title") String title,@Param("id") Integer id, @Param("path") String path);
}
