package com.example.lambtvnb6.Base;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;
@Documented//Định nghĩa đây là một anotion tự định nghĩa
@Target(ElementType.TYPE)//Kiểu phần tử là kiểu TYPE
@Retention(RetentionPolicy.RUNTIME)//Phương thức này sẽ được sử lys trong thời gian runtime
@RestController
@RequestMapping("/api/v1")
public @interface RestApiV1 {
}
