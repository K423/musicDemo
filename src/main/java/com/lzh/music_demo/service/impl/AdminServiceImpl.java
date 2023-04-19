package com.lzh.music_demo.service.impl;

import com.lzh.music_demo.data.Admin;
import com.lzh.music_demo.mapper.AdminMapper;
import com.lzh.music_demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    /**
     * 登录处理 逻辑实现
     * @param admin
     * @return
     */
    @Override
    public Admin verified(Admin admin) {
        return adminMapper.query(admin);
    }
}
