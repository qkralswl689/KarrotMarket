package com.karrot.karrotmarket.user.service;

import com.karrot.karrotmarket.user.dto.LoginDto;
import com.karrot.karrotmarket.user.dto.UserDto;
import com.karrot.karrotmarket.user.entity.UserEntity;
import com.karrot.karrotmarket.user.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @Override
    public boolean login(LoginDto user) {

        UserEntity findUser = userInfoRepository.findByEmail(user.getEmail());

        if(findUser == null){
            return false;
        }
        if(!findUser.getPassword().endsWith(user.getPassword())){
            return false;
        }
        return true;
    }

   /* @Override
    public UserEntity login(String loginId, String password) {
        UserEntity user = userInfoRepository.findByEmail(loginId);

        if(!user.getPassword().equals(password)){
            return null;
        }

        return userInfoRepository.findByEmail(loginId);
    }*/

    @Override
    public UserEntity getNickname(String email) {

        UserEntity user = userInfoRepository.findByEmail(email);

        UserEntity users = UserEntity.builder().nickName(user.getNickName()).build();
        return users;
    }

  /*  @Override
    public UserEntity login(Map<String, String> map) throws Exception {
        return userInfoRepository.getById();
    }*/

/*    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // 로그인을 하기 위해 가입된 user정보를 조회하는 메서드
        Optional<UserEntity> memberWrapper = Optional.ofNullable(userInfoRepository.findByEmail(email));
        UserEntity member = memberWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if("admin".equals(email)){
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        // 아이디, 비밀번호, 권한리스트를 매개변수로 User를 만들어 반환해준다.
        return new UserEntity(member.getEmail(), member.getPassword(), authorities);
    }*/


}
