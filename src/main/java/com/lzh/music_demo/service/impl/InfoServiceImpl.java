package com.lzh.music_demo.service.impl;

import com.lzh.music_demo.data.Info;
import com.lzh.music_demo.mapper.InfoMapper;
import com.lzh.music_demo.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public Info query() {
        /**
         * 用户数
         */
        Long userNum = infoMapper.userCount();
        /**
         * 歌手数
         */
        Long singerNum = infoMapper.singerCount();
        /**
         * 歌曲数
         */
        Long songNum = infoMapper.songCount();

        /**
         * 用户性别
         */
        Long userGender0  = infoMapper.userGender0();
        Long userGender1  = infoMapper.userGender1();
        /**
         * 歌手性别
         */
        Long singerGender0 = infoMapper.singerGender0();
        Long singerGender1 = infoMapper.singerGender1();

        Info info = new Info(userNum, singerNum, songNum,
                userGender0, userGender1,
                singerGender0, singerGender1);
        return info;
    }
}
