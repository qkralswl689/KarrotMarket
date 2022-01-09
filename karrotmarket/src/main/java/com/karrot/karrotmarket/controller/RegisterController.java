package com.karrot.karrotmarket.controller;

import com.karrot.karrotmarket.service.UserService;
import com.karrot.karrotmarket.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RegisterController {
    private final UserService userService;

    @PostMapping("/register")
    public String Register(@RequestBody UserVO request){
        return userService.register(request);
    }


}
