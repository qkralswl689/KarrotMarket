package com.karrot.karrotmarket.file.dto;

import com.karrot.karrotmarket.file.entity.FileEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileDto {

    private int fileIndex; // 파일번호
/*
    private int postIndex; // 게시물번호
*/
    private String fileName; // 저장할때
    private String fileOriginName; // 받아올 때 파일 이름
    private String filePath; // 저장 및 불러올 경로

    public FileEntity toEntity(){
        FileEntity build = FileEntity.builder()
                .fileNo(fileIndex)
                .fileOriginName(fileOriginName)
                .fileName(fileName)
                .filePath(filePath)
                .build();
        return build;
    }


    @Builder
    public FileDto(int fileIndex, String fileName, String fileOriginName, String filePath) {
        this.fileIndex = fileIndex;
        this.fileName = fileName;
        this.fileOriginName = fileOriginName;
        this.filePath = filePath;
    }
}