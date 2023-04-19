package com.lzh.music_demo.controller;

import com.lzh.music_demo.data.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 上传图片
 */
@RestController
public class UploadController {

    //定义存储路径
    public static final String BASE_PATH = "D:\\Alex\\IDEA\\work\\music_demo\\src\\main\\resources\\static\\img\\";
    public static final String SONG_BASE_PATH = "D:\\Alex\\IDEA\\work\\music_demo\\src\\main\\resources\\static\\song\\";
    //定义图片访问路径
    private static final String SERVER_PATH = "http://localhost:8080/upload/";
    //定义歌曲访问路径
    private static final String SONG_SERVER_PATH = "http://localhost:8080/upload/song/";

    //上传图片方法
    @PostMapping("/upload")
    public Result upload(@RequestParam(value = "pic") MultipartFile file) {
        //获取上传文件名称
        String filename = file.getOriginalFilename();
        //确保唯一性 使用UUID对filename改写
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //拼接
        String newFilename = uuid + "-" + filename;
        //创建文件实例对象
        File img = new File(BASE_PATH, newFilename);
        if (!img.exists()) {
            img.mkdir();
        }
        //缺少判断
        //上传操作
        try {
            file.transferTo(img);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(SERVER_PATH + newFilename);
        return Result.success(SERVER_PATH + newFilename);
    }

    @PostMapping("/upload/song")
    public Result upload_song(@RequestParam(value = "url") MultipartFile mp3) {
        //获取上传文件名称
        String mp3name = mp3.getOriginalFilename();
        //确保唯一性 使用UUID对filename改写
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //拼接
        String mp3Filename = uuid + "-" + mp3name;
        //创建文件实例对象
        File f = new File(SONG_BASE_PATH, mp3Filename);
        if (!f.exists()) {
            f.mkdir();
        }
        //缺少判断操作
        //上传操作
        try {
            mp3.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(SONG_SERVER_PATH + mp3Filename);
        return Result.success(SONG_SERVER_PATH + mp3Filename);
    }
}
