package com.lzh.music_demo.mapper;

import com.lzh.music_demo.data.Song;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SongMapper {
    @Insert("insert into song (singer_id,singer_name, name, pic, lyric, url, create_time, update_time) " +
            "VALUES (#{singerId}, #{singerName}, #{name}, #{pic}, #{lyric}, #{url}, #{createTime}, #{updateTime})")
    void insert(Song song);

    @Delete("delete from song where id = #{id}")
    void delete(Integer id);


    void update(Song song);

    @Select("select * from song where id = #{id}")
    Song getById(Integer id);
    
    
    List<Song> query(Integer page, Integer pageSize, String name, Integer singerId);

    long count(String name, Integer singerId);
}
