package com.karrot.karrotmarket.user.controller;

import com.karrot.karrotmarket.user.dto.LoginDto;
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

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

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDto loginDto, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }
        UserEntity loginUser = userService.login(loginDto.getEmail(),loginDto.getPassword());

        if (loginUser == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }
        return "/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam Map<String, String> map, Model model, HttpSession session) {
        try {
            if (map.get("userid") == null || map.get("userpwd") == null) {
                model.addAttribute("msg", "아이디 또는 비밀번호를 입력해주세요");
                return "error/error";
            }
            UserEntity user = userService.login(map);
            if (user != null) {
                session.setAttribute("user", user);
            } else {
                model.addAttribute("msg", "아이디 또는 비밀번호가 올바르지 않습니다.");
                return "error/error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "로그인 중 문제가 발생했습니다.");
            return "error/error";
        }
        return "index";
    } // end of PostMapping("login")
}
