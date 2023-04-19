package com.lzh.music_demo.controller;

import com.lzh.music_demo.data.Page;
import com.lzh.music_demo.data.Result;
import com.lzh.music_demo.data.Song;
import com.lzh.music_demo.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SongController {
    @Autowired
    private SongService songService;

    /**
     * 增加歌曲
     */
    @PostMapping("/song")
    public Result add(@RequestBody Song song) {
        songService.add(song);
        return Result.success();
    }

    /**
     * 删除歌曲
     */
    @DeleteMapping("/song/{id}")
    public Result delete(@PathVariable Integer id) {
        songService.delete(id);
        return Result.success();
    }

    /**
     * 修改歌曲
     */
    @PutMapping("/song")
    public Result update(@RequestBody Song song) {
        songService.update(song);
        return Result.success();
    }

    /**
     * 根据id查询
     */
    @GetMapping("/song/{id}")
    public Result getById(@PathVariable Integer id) {
        Song s = songService.getById(id);
        return Result.success(s);
    }

    /**
     * 查找歌曲 (条件查询 为 根据歌手id)
     */
    @GetMapping("/song")
    public Result list(@RequestParam(defaultValue = "1") Integer page, //当前页面页码
                       @RequestParam(defaultValue = "5") Integer pageSize, //单页显示记录数
                       String name, Integer singerId) {
        Page p = songService.query(page, pageSize, name, singerId);
        return Result.success(p);
    }
}

