package com.example.buoi7.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//@RestController
//@RequestMapping("/files")
public class FileController {
    //private final Path rootPath = Paths.get(System.getProperty("user.dir"));

//    @PostMapping
//    public String uploadFile(@RequestPart(value = "img" ,required = false)MultipartFile file) throws IOException {
////MultipartFile sử dụng khi file lấy từ form hay postman lên nó nhận là multipartFile
//        Path path = Paths.get(rootPath + "/src/main/resources/static/");
//        Path path2 = path.resolve(file.getOriginalFilename());
//
//        try(OutputStream os = Files.newOutputStream(path2)){
//            os.write(file.getBytes());
//        }
////        return path.toString();
//    return file.getOriginalFilename();
//    }
}
