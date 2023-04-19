package com.lzh.music_demo.service.impl;

import com.lzh.music_demo.data.Page;
import com.lzh.music_demo.data.Singer;
import com.lzh.music_demo.mapper.SingerMapper;
import com.lzh.music_demo.service.SingerService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerServiceImpl implements SingerService {
    @Autowired
    private SingerMapper singerMapper;

    @Override
    public void add(Singer singer) {
        singerMapper.add(singer);
    }

    @Override
    public void update(Singer singer) {
        singerMapper.update(singer);
    }

    @Override
    public void delete(List<Integer> ids) {
        singerMapper.delete(ids);
    }

    @Override
    public Singer getById(Integer id) {
        return singerMapper.getByID(id);
    }

    @Override
    public Page query(Integer page, Integer pageSize, String name, Integer gender) {
        //总计数
        long count = singerMapper.count(name, gender);
        //单页数据
        List<Singer> singerList = singerMapper.query((page - 1) * pageSize, pageSize, name, gender);
        //封装数据
        Page p = new Page(count, singerList);
        return p;
    }

}
