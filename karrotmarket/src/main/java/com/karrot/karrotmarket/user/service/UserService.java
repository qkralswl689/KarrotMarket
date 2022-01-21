package com.karrot.karrotmarket.user.service;

import com.karrot.karrotmarket.user.dto.LoginDto;
import com.karrot.karrotmarket.user.dto.UserDto;
import com.karrot.karrotmarket.user.entity.UserEntity;

import java.util.Map;

public interface UserService {

    public String register(UserDto userDto);

    public boolean login(LoginDto user);

/*
    public UserEntity login(String loginId, String password);
*/

    public UserEntity getNickname(String email);

    public UserEntity getUserIndex(String email);

/*
    public UserEntity login(Map<String, String > map) throws Exception;
*/

/*
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
*/
}
