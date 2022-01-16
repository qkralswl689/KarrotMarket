package com.karrot.karrotmarket.file.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "file")
public class FileEntity {

    @Id
    @Column(name = "fileindex")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int fileNo; // 파일번호

    @Column(name = "filename")
    private String fileName; // 저장할때

    @Column(name = "fileoriginname")
    private String fileOriginName; // 받아올 때 파일 이름

    @Column(name = "filepath")
    private String filePath; // 저장 및 불러올 경로

    @Column(name = "create_time")
    private LocalDateTime createDateTime = LocalDateTime.now();

    @Column(name = "modify_time")
    private LocalDateTime modifyDateTime ;

    @Builder
    public FileEntity(int fileNo, String fileName, String fileOriginName, String filePath){
        this.fileNo = fileNo;
        this.fileName = fileName;
        this.fileOriginName = fileOriginName;
        this.filePath = filePath;
    }
}
