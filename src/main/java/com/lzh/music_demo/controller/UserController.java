package com.lzh.music_demo.controller;

import com.lzh.music_demo.data.Page;
import com.lzh.music_demo.data.Result;
import com.lzh.music_demo.data.User;
import com.lzh.music_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 显示列表
     * @param page
     * @param pageSize
     * @param username
     * @param gender
     * @return
     */
    @GetMapping("/Manager_user")
    public Result list(@RequestParam(defaultValue = "1") Integer page, //当前页面页码
                       @RequestParam(defaultValue = "5") Integer pageSize, //单页显示记录数
                       String username, Integer gender){
        Page p = userService.list(page, pageSize, username, gender);
        return Result.success(p);
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/Manager_user/{id}")
    public Result delete(@PathVariable Integer id){
        userService.delete(id);
        return Result.success();
    }

    /**
     * 修改用户
     */
    @PutMapping("/Manager_user")
    public Result update(@RequestBody User user){
        userService.update(user);
        return Result.success();
    }

    /**
     * 添加用户
     */
    @PostMapping("/Manager_user")
    public Result add(@RequestBody User user){
        userService.add(user);
        return Result.success();
    }
}
