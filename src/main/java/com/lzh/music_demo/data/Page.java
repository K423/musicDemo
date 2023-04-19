package com.lzh.music_demo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页查询实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page {
    private Long total; //总数据数目
    private List rows; // 数据列表
}
