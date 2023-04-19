package com.lzh.music_demo.service.impl;

import com.lzh.music_demo.data.Page;
import com.lzh.music_demo.data.User;
import com.lzh.music_demo.mapper.UserMapper;
import com.lzh.music_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Page list(Integer page, Integer pageSize, String username, Integer gender) {
        //总计数
        long count = userMapper.count(username, gender);
        //单页数据
        List<User> users = userMapper.query((page - 1) * pageSize, pageSize, username, gender);
        //封装数据
        Page p = new Page(count, users);
        return p;
    }

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public void add(User user) {
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.add(user);
    }
}
