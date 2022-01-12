package com.karrot.karrotmarket.user.controller;

import com.karrot.karrotmarket.user.dto.UserDto;
import com.karrot.karrotmarket.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/join")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/register")
    public String register(UserDto userdto){

        userService.register(userdto);
        return "/redirect:/goToLogin";
    }
}
