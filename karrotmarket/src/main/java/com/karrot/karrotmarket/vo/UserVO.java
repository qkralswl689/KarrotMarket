package com.karrot.karrotmarket.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class UserVO {

    private Long usertIdx;
    private String email;
    private String password;
    private String phonenNumber;
    private String nickName;
    private String userName;


}
