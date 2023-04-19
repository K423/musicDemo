package com.lzh.music_demo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Singer {
    private Integer id;
    private String name;
    private Integer gender;
    private String pic;
    private String location;
    private String introduction;
}
