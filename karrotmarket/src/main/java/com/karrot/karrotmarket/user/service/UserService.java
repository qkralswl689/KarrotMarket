package com.karrot.karrotmarket.user.service;

import com.karrot.karrotmarket.user.dto.UserDto;
import com.karrot.karrotmarket.user.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Map;

public interface UserService {

    public String register(UserDto userDto);

    public boolean login(UserDto user);

    public UserEntity login(String loginId, String password);

    public UserEntity login(Map<String, String > map) throws Exception;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
}
