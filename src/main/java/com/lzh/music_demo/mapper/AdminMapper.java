package com.lzh.music_demo.mapper;

import com.lzh.music_demo.data.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 数据处理接口
 */
@Mapper
public interface AdminMapper {
    /**
     * 数据查询
     * @param admin
     * @return
     */
    @Select("select * from admin where name = #{name} and password = #{password}")
    Admin query(Admin admin);
}
