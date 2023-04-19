package com.lzh.music_demo.controller;

import com.lzh.music_demo.data.Info;
import com.lzh.music_demo.data.Result;
import com.lzh.music_demo.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @Autowired
    private InfoService infoService;
    /**
     * 获取用户数量
     */
    /**
     * 获取歌曲数量
     */
    /**
     * 获取歌手数量
     */
    @GetMapping("/info")
    public Result getSum(){
        Info info = infoService.query();
        return Result.success(info);
    }
}
