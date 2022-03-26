package com.hit.btvn_b4.Controller;

import com.hit.btvn_b4.Model.User;
import com.hit.btvn_b4.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("user" , new User());
        model.addAttribute("message" , "");
        return "login";
    }
    @PostMapping("/login")
    public String postLogin(@ModelAttribute("user") User user , Model model){
       List<User> users = userRepository.findAll();
        if(users.contains(user)){
            return "redirect:/";
        }
        model.addAttribute("message" , "Username or password not invaid");
        return "login";
    }
   @GetMapping
    public String getData(Model model){
       model.addAttribute("dataUser" , userRepository.findAll());
       return "data";
   }
}
