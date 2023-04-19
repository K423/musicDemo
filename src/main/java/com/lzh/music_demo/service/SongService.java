package com.lzh.music_demo.service;

import com.lzh.music_demo.data.Page;
import com.lzh.music_demo.data.Song;

public interface SongService {
    /**
     * add
     * @param song
     */
    void add(Song song);

    /**
     *delete
     * @param id
     */
    void delete(Integer id);

    /**
     * update
     * @param song
     */
    void update(Song song);

    /**
     * ID search
     * @param id
     * @return
     */
    Song getById(Integer id);

    /**
     * search
     * @param page
     * @param pageSize
     * @param singerId
     * @return
     */
    Page query(Integer page, Integer pageSize, String name, Integer singerId);
}
