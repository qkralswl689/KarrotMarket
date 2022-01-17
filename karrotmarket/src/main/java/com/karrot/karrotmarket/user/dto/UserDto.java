package com.karrot.karrotmarket.user.dto;

import com.karrot.karrotmarket.user.entity.UserEntity;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
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
    private LocalDateTime createDate;

    public UserEntity toEntity(){
        UserEntity build = UserEntity.builder()
                .email(email)
                .password(password)
                .userName(userName)
                .phonenNumber(phonenNumber)
                .nickName(nickName)
                .build();
        return build;
    }

    @Builder
    public void UserDto(String email, String password,  String userName,String phonenNumber, String nickName,LocalDateTime createDate){
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.phonenNumber =phonenNumber;
        this.nickName = nickName;
        this.createDate = createDate;
    }

    @Builder
    public void UerDto(String email, String password){
        this.email = email;
        this.password = password;
    }




}
