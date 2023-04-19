package com.lzh.music_demo.configuration;


import com.lzh.music_demo.controller.UploadController;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    /**
     * 配置静态资源路径 图片、mp3
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:///" + UploadController.BASE_PATH);
        registry.addResourceHandler("/upload/song/**")
                .addResourceLocations("file:///" + UploadController.SONG_BASE_PATH);

    }
}
