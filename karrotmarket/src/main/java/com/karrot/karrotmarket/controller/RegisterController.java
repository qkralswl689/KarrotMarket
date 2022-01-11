package com.karrot.karrotmarket.controller;

import com.karrot.karrotmarket.repository.UserInfoRepository;
import com.karrot.karrotmarket.service.UserService;
import com.karrot.karrotmarket.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Controller
public class RegisterController {
    @Autowired
    UserInfoRepository userInfoRepository;

    private final UserService userService;

    @PostMapping("/register")
    public String Register(@RequestBody UserVO userVO){

     /*   String userEmail = userVO.getEmail();
        String password = userVO.getPassword();
        String userName = userVO.getUserName();
        String phone = userVO.getPhonenNumber();
        String nicName = userVO.getNickName();

        UserVO userVo = new UserVO();
        userVo.set
*/
        return userService.register(userVO);
    }


}
