package com.karrot.karrotmarket.controller;

import com.karrot.karrotmarket.category.CategoryEntity;
import com.karrot.karrotmarket.category.CategoryRepository;
import com.karrot.karrotmarket.user.dto.UserDto;
import com.karrot.karrotmarket.user.entity.UserEntity;
import com.karrot.karrotmarket.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class KarrotMarketController {
    private CategoryRepository categoryRepository;
    private UserServiceImpl userService;

    public KarrotMarketController(CategoryRepository categoryRepository,UserServiceImpl userService){
        this.categoryRepository = categoryRepository;
        this.userService = userService;
    }

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

    @GetMapping("/salePage")
    public String salePage(HttpSession session, Model model) {
        List<CategoryEntity> category = categoryRepository.findAll();

        model.addAttribute("category",category);
        return "html/salePage";
    }
    @GetMapping("/myPage")
    public String myPage(HttpSession session, Model model) {

        String sessionUser = (String) session.getAttribute("email");

        String nickName = userService.getNickname(sessionUser).getNickName();
        model.addAttribute("nickname",nickName);



        return "html/myPage";
    }

    @GetMapping("/profile")
    public String profile(HttpSession session, Model model) {
        return "html/modifyProfile";
    }

    @GetMapping("/productDetail")
    public String productDetail(HttpSession session, Model model) {
        return "html/productDetail";
    }

}
