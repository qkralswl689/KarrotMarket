package com.karrot.karrotmarket.controller;

import com.karrot.karrotmarket.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("goToLogin")
    public String goToLogin(HttpSession session, Model model) {
        return "html/goToLogin";
    }

    @GetMapping("login")
    public String login(HttpSession session, Model model) {
        return "html/login";
    }

    @GetMapping("home")
    public String home(HttpSession session, Model model) {
        return "html/home";
    }

    @PostMapping("save")
    public String save(@ModelAttribute UserEntity userEntity){
        
    }
}
