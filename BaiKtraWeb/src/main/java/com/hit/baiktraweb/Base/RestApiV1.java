package com.hit.baiktraweb.Base;

import org.hibernate.annotations.Nationalized;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping("/api/v1/")
@RestController
public @interface RestApiV1 {
}
