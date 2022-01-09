package com.karrot.karrotmarket.service;

import com.karrot.karrotmarket.entity.UserEntity;
import com.karrot.karrotmarket.repository.UserInfoRepository;
import com.karrot.karrotmarket.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserInfoRepository userInfoRepository;

    @Override
    public String register(UserVO userVO) {
        try {
            userInfoRepository.save(
                    UserEntity.builder()
                            .email(userVO.getEmail())
                            .password(userVO.getPassword())
                            .build()
            );
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "fail";
    }
}
