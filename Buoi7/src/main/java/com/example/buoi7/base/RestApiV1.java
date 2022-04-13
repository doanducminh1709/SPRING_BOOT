package com.example.buoi7.base;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;
//phương thức định nghĩa sẵn các phương thức cần thiết , định nghĩa sẵn
//chỉ cần khai bóa ở trong các class khác
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping("/api/v1/")
@RestController
public @interface RestApiV1 {
}
