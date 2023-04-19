package com.lzh.music_demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface InfoMapper {

    Long userCount();


    Long singerCount();


    Long songCount();

    Long singerGender0();

    Long singerGender1();

    Long userGender0();

    Long userGender1();
}
