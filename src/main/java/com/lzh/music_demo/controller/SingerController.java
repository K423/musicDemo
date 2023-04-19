package com.lzh.music_demo.controller;

import com.lzh.music_demo.data.Result;
import com.lzh.music_demo.data.Singer;
import com.lzh.music_demo.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lzh.music_demo.data.Page;


import java.util.List;

@RestController
public class SingerController {
    @Autowired
    private SingerService singerService;

    /**
     * 增加歌手
     */
    @PostMapping("/singer")
    public Result add(@RequestBody Singer singer){
        singerService.add(singer);
        return Result.success();
    }

//    @PostMapping("/upload")
//    public Result upload(MultipartFile pic) throws IOException {
//        String picName = pic.getOriginalFilename();
//        pic.transferTo(new File("D:\\Alex\\" + picName));
//        return Result.success();
//    }
    /**
     * 修改歌手信息
     */
    @PutMapping("/singer")
    public Result update(@RequestBody Singer singer){
        singerService.update(singer);
        return Result.success();
    }
    /**
     * 删除歌手
     */
    @DeleteMapping("/singer/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        singerService.delete(ids);
        return Result.success();
    }
    /**
     * 查询操作 分类
     */
    /**
     * 根据id查询
     */
    @GetMapping("/singer/{id}")
    public Result getById(@PathVariable Integer id){
        Singer s = singerService.getById(id);
        return Result.success(s);
    }
    /**
     * 查询所有歌手 或 根据条件查询 姓名或性别
     */
    @GetMapping("/singer")
    public Result list(@RequestParam(defaultValue = "1") Integer page, //当前页面页码
                       @RequestParam(defaultValue = "5") Integer pageSize, //单页显示记录数
                       String name, Integer gender){
        Page p = singerService.query(page, pageSize, name, gender);
        return Result.success(p);
    }

}
