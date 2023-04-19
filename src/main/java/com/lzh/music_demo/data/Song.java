package com.lzh.music_demo.data;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    private Integer id;
    private Integer singerId; //歌手id
    private String singerName;
    private String name;
    private String pic;
    private String lyric;
    private String url;

    //避免返回的date为数组形式
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime; //创建时间

    //返回类型
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    //接受类型
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime; //更新时间
}
