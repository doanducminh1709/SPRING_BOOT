package com.example.luyentap.Controller;

import com.example.luyentap.model.Province;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
public class AppController {
    private ObjectMappper objectMappper = new ObjectMapper();

    @GetMapping
    public ResponseEntity<?> getData() throws IOException {
        ClassPhathResource cpr = new ClassPathResource("static/data-simple/tinh-tp.json");
        byte[] bData = FileCopyUtils.copyToByteArray(cpr.getInputStream());
        String data = new String(bData, StandardCharsets.UTF_8);
        Province[] provinces = objectMappper.readValues(getData());
       for(Province province : provinces){
           System.out.println(province);
       }
        //anotion Valied dung thay cho RequestParam
        // đọc file Json
        // Parge String to Object
        // Gửi nhiều param
        // Call aapi
        //Buoi sau
                //tao anotaion
                //tim hieu JMT
                //Mo hinh 3 lop trong spring boot
        return ResponseEntity.status(200).body(provinces);
       }

}
