package com.lzh.music_demo.service;

import com.lzh.music_demo.data.Page;
import com.lzh.music_demo.data.Result;
import com.lzh.music_demo.data.User;

public interface UserService {
    /**
     * 查询
     * @param page
     * @param pageSize
     * @param username
     * @param gender
     * @return
     */
    Page list(Integer page, Integer pageSize, String username, Integer gender);

    /**
     * 删除
     * @param id
     * @return
     */
    void delete(Integer id);

    /**
     * 更新用户信息
     * @param user
     */
    void update(User user);

    /**
     * 增加新用户
     * @param user
     */
    void add(User user);
}
