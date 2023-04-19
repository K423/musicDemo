package com.lzh.music_demo.mapper;

import com.lzh.music_demo.data.Singer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SingerMapper {
    /**
     * sql insert
     * @param singer
     */
    @Insert("insert into singer (name, gender, pic, location, introduction) " +
            "VALUES (#{name}, #{gender}, #{pic}, #{location}, #{introduction})")
    void add(Singer singer);

    /**
     * sql update
     * @param singer
     */
    void update(Singer singer);

    /**
     * sql delete
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * sql search id
     * @param id
     * @return
     */
    @Select("select * from singer where id = #{id}")
    Singer getByID(Integer id);

    /**
     * sql query
     * @param name
     * @param gender
     * @return
     */
    List<Singer> query(Integer page, Integer pageSize, String name, Integer gender);

    /**
     * sql count
     * @return
     */
    long count(String name, Integer gender);
}
