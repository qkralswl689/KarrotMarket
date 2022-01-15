package com.karrot.karrotmarket.user.controller;

import com.karrot.karrotmarket.user.dto.UserDto;
import com.karrot.karrotmarket.user.entity.UserEntity;
import com.karrot.karrotmarket.user.repository.UserInfoRepository;
import com.karrot.karrotmarket.user.service.UserServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.util.Date;

@Controller
@RequiredArgsConstructor
public class UserController {


    @Autowired
    private UserServiceImpl userService;


    private UserInfoRepository userInfoRepository;

/*    @RequestMapping(value="/register",method= RequestMethod.GET)
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
    }*/


    @PostMapping("/register")
    public String registerUser(UserDto userdto){


        userService.register(userdto);
        return "redirect:/goToLogin";
    }
}
