package com.karrot.karrotmarket.post.dto;

import com.karrot.karrotmarket.post.entity.PostEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PostDto {

    private int postIndex;
    private String title;
    private String content;
    private int price;
    private LocalDateTime createdDatetime = LocalDateTime.now();
    private LocalDateTime modifyDate = LocalDateTime.now();
    private String rangeTown;
    private int like;
    private int userindex;
    private int fileIndex;

    public PostEntity toEntity(){
        PostEntity build = PostEntity.builder()
                .postIndex(postIndex)
                .title(title)
                .content(content)
                .price(price)
                .fileIndex(fileIndex)
                .build();
        return build;
    }

    @Builder
    public PostDto(int postIndex,String title,String content,int price, int fileIndex,LocalDateTime createdDatetime,LocalDateTime modifyDate,String rangeTown, int like,int userindex){
        this.postIndex = postIndex;
        this.title = title;
        this.content = content;
        this.price = price;
        this.createdDatetime = createdDatetime;
        this.modifyDate = modifyDate;
        this.rangeTown = rangeTown;
        this.like = like;
        this.userindex = userindex;
        this.fileIndex = fileIndex;
    }

}
