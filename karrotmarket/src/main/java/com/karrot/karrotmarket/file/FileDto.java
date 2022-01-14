package com.karrot.karrotmarket.file;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class FileDto {

    private int fileNo; // 파일번호
    private int bordNo; // 게시물번호
    private String uuid; // unique 한 파일 이름을 만들기 위한 속성
    private String fileName; // 저장할때
    private String fileOriginName; // 받아올 때 파일 이름
    private String fileUrl; // 저장 및 불러올 경로
    private String contentType;

    public FileDto(){}

    public FileDto(String uuid, String fileName, String contentType){
        this.uuid = uuid;
        this.fileName = fileName;
        this.contentType = contentType;

    }

}