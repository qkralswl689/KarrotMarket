package com.karrot.karrotmarket.user.service;

import com.karrot.karrotmarket.user.dto.UserDto;
import com.karrot.karrotmarket.user.entity.UserEntity;
import com.karrot.karrotmarket.user.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserInfoRepository userInfoRepository;

    public UserServiceImpl(UserInfoRepository userInfoRepository){
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public String register(UserDto userDto) {
        try {
            userInfoRepository.save(
                    UserEntity.builder()
                            .email(userDto.getEmail())
                            .password(userDto.getPassword())
                            .userName(userDto.getUserName())
                            .phonenNumber(userDto.getPhonenNumber())
                            .nickName(userDto.getNickName())
                            .build()
            );
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "fail";
    }
}
