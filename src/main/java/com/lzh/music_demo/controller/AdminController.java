package com.lzh.music_demo.controller;

import com.lzh.music_demo.data.Admin;
import com.lzh.music_demo.data.Result;
import com.lzh.music_demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制层
 */
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;
    /**
     * 登录
     */
    @PostMapping("/login")
    public Result login(@RequestBody Admin admin){
        Admin ad = adminService.verified(admin);
        if (ad != null){
            return Result.success(admin);
        }
        return Result.error("用户名或密码错误");
    }
}
