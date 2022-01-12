package com.karrot.karrotmarket.controller;

import com.karrot.karrotmarket.user.dto.UserDto;
import com.karrot.karrotmarket.user.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class KarrotMarketController {


    @GetMapping
    public String Hello(Model model) {
        return "index";
    }

    @GetMapping("/join")
    public String join(HttpSession session, Model model) {

/*
        User loginUser = (User)session.getAttribute("ConfirmUser");
        model.addAttribute("loginUser", loginUser);*/

        return "html/join";

    }

    @GetMapping("/goToLogin")
    public String goToLogin(HttpSession session, Model model) {
        return "html/goToLogin";
    }

    @GetMapping("/login")
    public String login(HttpSession session, Model model) {
        return "html/login";
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        return "html/home";
    }


}
