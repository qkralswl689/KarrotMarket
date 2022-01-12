package com.karrot.karrotmarket.controller;

import com.karrot.karrotmarket.user.dto.UserDto;
import com.karrot.karrotmarket.user.entity.UserEntity;
import com.karrot.karrotmarket.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class KarrotMarketController {

    @Autowired
    private UserServiceImpl userService;

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

    @RequestMapping(value="/register",method=RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("userForm", new UserEntity());
        return "register";
    }

    // 회원가입 처리 후 로그인
    @RequestMapping(value="/register",method=RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") UserEntity userForm, BindingResult bindingResult,
                               Model model ){
        String password = userForm.getPassword();
        //userService.register(userForm);
        //securityService.autologin(userForm.getUsername(),password);
        return "/redirect:/goToLogin";
    }


    @PostMapping("/register")
    public String register(UserDto userdto){

        userService.register(userdto);
        return "/redirect:/goToLogin";
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
