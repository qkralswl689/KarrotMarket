package com.karrot.karrotmarket.user.dto;

import com.karrot.karrotmarket.user.entity.UserEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
public class UserDto {
    private String email;
    private String password;
    private String phonenNumber;
    private String nickName;
    private String userName;
    private Date joinDate;

    public UserEntity toEntity(){
        UserEntity build = UserEntity.builder()
                .email(email)
                .password(password)
                .phonenNumber(phonenNumber)
                .nickName(nickName)
                .userName(userName)
                .joinDate(joinDate)
                .build();
        return build;
    }



}
