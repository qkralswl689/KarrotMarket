package com.karrot.karrotmarket.user.service;

import com.karrot.karrotmarket.user.dto.UserDto;
import com.karrot.karrotmarket.user.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserInfoRepository userInfoRepository;

    public UserServiceImpl(UserInfoRepository userInfoRepository){
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    @Transactional
    public String register(UserDto userDto) {
       return userInfoRepository.save(userDto.toEntity()).getEmail();
    }

}
