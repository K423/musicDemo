package com.lzh.music_demo.service;

import com.lzh.music_demo.data.Page;
import com.lzh.music_demo.data.Singer;

import java.util.List;

public interface SingerService {
    /**
     * 增加歌手
     * @param singer
     */
    void add(Singer singer);

    /**
     * 修改歌手信息
     * @param singer
     */
    void update(Singer singer);

    /**
     * 删除歌手信息
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 获取歌手信息 根据id
     * @param id
     * @return
     */
    Singer getById(Integer id);

    /**
     * 查询歌手信息 条件查询
     * @param name
     * @param gender
     * @return
     */
//    List<Singer> query(String name, Integer gender);
    Page query(Integer page, Integer pageSize, String name, Integer gender);
}
