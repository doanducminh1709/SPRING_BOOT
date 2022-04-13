package com.example.luyentap;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import org.apache.catalina.connector.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class LuyenTapApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuyenTapApplication.class, args);
    }
    Moshi moshi = new Moshi.Builder().build();
    JsonAdapter<?> adapter = moshi.adapter(Province[].class);
    String url = "http://localhost8080/provinces";
    Response response = Resquest.Get(url).excute();
    System.out.println(new String(response.returnContent().asBytes(),StandardCharsets.UTF_8));
    String data = new String (response.returnContent().asBytes() , StandardCharsets.UTF_8);
    return ResponseEntity.status(200).body(district);
}
