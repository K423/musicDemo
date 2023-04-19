package com.lzh.music_demo.service.impl;

import com.lzh.music_demo.data.Page;
import com.lzh.music_demo.data.Song;
import com.lzh.music_demo.mapper.SongMapper;
import com.lzh.music_demo.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongMapper songMapper;

    @Override
    public void add(Song song) {
        song.setCreateTime(LocalDateTime.now());
        song.setUpdateTime(LocalDateTime.now());
        songMapper.insert(song);
    }

    @Override
    public void delete(Integer id) {
        songMapper.delete(id);
    }

    @Override
    public void update(Song song) {
        song.setUpdateTime(LocalDateTime.now());
        songMapper.update(song);
    }

    @Override
    public Song getById(Integer id) {
        return songMapper.getById(id);
    }

    @Override
    public Page query(Integer page, Integer pageSize, String name, Integer singerId) {
        //总计数
        long count = songMapper.count(name, singerId);
        //单页数据
        List<Song> songsList = songMapper.query((page - 1) * pageSize, pageSize, name, singerId);
        //封装数据
        Page p = new Page(count, songsList);
        return p;
    }
}
