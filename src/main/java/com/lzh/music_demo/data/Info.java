package com.lzh.music_demo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Info {
    private Long userNum;
    private Long singerNum;
    private Long songNum;
    //用户性别
    private Long userGender0;
    private Long userGender1;
    //歌手性别
    private Long singerGender0;
    private Long singerGender1;
}
