package com.lzh.music_demo.mapper;

import com.lzh.music_demo.data.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    long count(String username, Integer gender);

    List<User> query(Integer page, Integer pageSize, String username, Integer gender);

    void delete(Integer id);

    void update(User user);

    @Insert("insert into user_table (username, password, gender, phone, email, avatar, create_time, update_time)" +
            " VALUES (#{username}, #{password}, #{gender}, #{phone}, #{email}, " +
            "#{avatar}, #{createTime}, #{updateTime})")
    void add(User user);
}
