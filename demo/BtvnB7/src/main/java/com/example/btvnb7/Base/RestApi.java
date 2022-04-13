package com.example.btvnb7.Base;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.annotation.*;


@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping("/api/v1/")
@RestController
public @interface RestApi {
}
