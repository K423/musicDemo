package com.lzh.music_demo.service;

import com.lzh.music_demo.data.Admin;

/**
 * 逻辑处理接口
 */
public interface AdminService {
    /**
     * 登录处理
     * @param admin
     * @return
     */
    Admin verified(Admin admin);
}
