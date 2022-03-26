package com.hit.btvn_b4.Controller;
import com.hit.btvn_b4.Dto.UserDto;
import com.hit.btvn_b4.Model.User;
import com.hit.btvn_b4.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/hit")
public class ApiController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<?> getListUser(){
      List<User> userList = userRepository.findAll();
        return ResponseEntity.status(200).body(userList);
    }
    //Tim theo ma id
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable(name = "id" ) Long id){
        Optional<User> userOptional = userRepository.findById(id);
        //return ResponseEntity.status(200).body(userRepository.findById(id));
        return ResponseEntity.status(200).body(userOptional.get());
    }

    @PostMapping
    public ResponseEntity<?> CreateUser(@RequestBody UserDto userDto){
        User user = new User();
        user.setFullName(userDto.getFullName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
    return ResponseEntity.status(200).body("Create successful!");
    }
}
