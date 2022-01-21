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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserController {


    @Autowired
    private UserServiceImpl userService;


    private UserInfoRepository userInfoRepository;


    @PostMapping("/login")
    public String loginId(@ModelAttribute LoginDto user, HttpServletRequest request) {
        if(userService.login(user)){

            String uid = request.getParameter("email");

            HttpSession session = request.getSession(); // 세션을 생성해서
            session.setAttribute("email", uid); // userid로 uid값을 넘기자

            return "redirect:/myPage";
        }
        return "/login";
    }



    @PostMapping("/register")
    public String registerUser(UserDto userdto){


        userService.register(userdto);
        return "redirect:/goToLogin";
    }


 /*   @GetMapping("/read")
    public String read( String email, Model model,HttpSession session) {

        UserEntity userEntity = userService.getNickname(email);
        model.addAttribute("user",userEntity);
     *//*   DiaryVO sessionDiary = (DiaryVO)session.getAttribute("diary");
        model.addAttribute("diary",sessionDiary);*//*

       *//* //세션에 저장된 유저 값을 불러온다.
        User loginUser = (User)session.getAttribute("ConfirmUser");
        model.addAttribute("loginUser", loginUser);*//*
*//*
        UserDto userDto = userService.;

        DiaryFileDto diaryFileDto = new DiaryFileDto();

        diaryFileDto.setId(diaryDto.getFileId());
        Long fileId = diaryDto.getFileId();

        DiaryFileDto fileList = fileService.getFile(fileId);

        diaryFileDto.setFilename(fileList.getFilename());
        diaryFileDto.setOrigFilename(fileList.getOrigFilename());
        diaryFileDto.setFilePath(fileList.getFilePath());


        model.addAttribute("post", diaryDto);
        model.addAttribute("postFile",fileList);*//*

        return "/productDetail";
    }*/
}
