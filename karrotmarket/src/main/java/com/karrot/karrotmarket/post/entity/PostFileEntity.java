package com.karrot.karrotmarket.post.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="file")
@NoArgsConstructor
@Data
public class PostFileEntity {

    @Id
    @Column(name = "fileindex")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int fileNo; // 파일번호

    @Column(name = "postindex")
    private int postNo; // 게시물번호

    @Column(name = "uuid")
    private String uuid; // unique 한 파일 이름을 만들기 위한 속성

    @Column(name = "filename")
    private String fileName; // 저장할때

    @Column(name = "fileoriginname")
    private String fileOriginName; // 받아올 때 파일 이름

    @Column(name = "fileurl")
    private String fileUrl; // 저장 및 불러올 경로

    @Column(name = "filetype")
    private String contentType;
}
