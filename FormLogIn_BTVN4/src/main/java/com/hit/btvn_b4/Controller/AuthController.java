package com.hit.btvn_b4.Controller;

import com.hit.btvn_b4.Model.User;
import com.hit.btvn_b4.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/edit")
    public String getEditPage(@RequestParam("id") Long id, Model model) {
        model.addAttribute("account", userRepository.getById(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String processEditUser(@ModelAttribute("account") User user) {
        User newUser = new User(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getFullName()
        );
        userRepository.save(newUser);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model) {
        model.addAttribute("account", new User());
        return "create";
    }

    @PostMapping("/create")
    public String ProcessCreateUser(@ModelAttribute("account") User user) {
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String getDeletePage(@RequestParam("id") Long id, Model model) {
        model.addAttribute("account", userRepository.getById(id));
        return "config";
    }

    @PostMapping("/delete")
    public String processDeleteUser(@ModelAttribute("account") User user) {
        userRepository.deleteById(user.getId());
        return "redirect:/";
    }
}
