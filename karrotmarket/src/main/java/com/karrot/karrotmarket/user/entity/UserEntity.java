package com.karrot.karrotmarket.user.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
/*@SequenceGenerator(
        name="USER_SEQ_GEN", //시퀀스 제너레이터 이름
        sequenceName="user_seq", //시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
)*/
public class UserEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_index")
    private Long usertIdx;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "username")
    @NotNull
    private String userName;

    @Column(name = "phonenumber")
    private String phonenNumber;

    @Column(name = "nickname")
    private String nickName;

    @Column(name="create_date")
    private LocalDateTime createdDatetime = LocalDateTime.now();


    public UserEntity(String email,String password){
        this.email = email;
        this.password = password;
    }
}
