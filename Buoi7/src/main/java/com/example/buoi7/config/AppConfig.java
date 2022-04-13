package com.example.buoi7.config;

import com.github.slugify.Slugify;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
@Bean
        public ModelMapper modelMapper(){
        return new ModelMapper();
    }


//slugify là kĩ thuật chuyển hóa chữ thành những dạng chữ và số không dấu
@Bean
    public Slugify slugify(){
    return  new Slugify();
   }
}
