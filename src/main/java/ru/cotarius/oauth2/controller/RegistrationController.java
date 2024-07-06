package ru.cotarius.oauth2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.cotarius.oauth2.enity.Role;
import ru.cotarius.oauth2.enity.User;
import ru.cotarius.oauth2.repository.UserRepo;

import java.util.Collections;

@Controller
@RequiredArgsConstructor
public class RegistrationController {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(String name, String username, String password){
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));

        userRepo.save(user);

        return "redirect:/login";
    }
}
