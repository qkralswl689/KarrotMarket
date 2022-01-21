package com.karrot.karrotmarket.post.entity;

import lombok.Builder;
import lombok.CustomLog;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="post")
@NoArgsConstructor
@Data
public class PostEntity {

    @Id
    @Column(name = "postindex")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int postIndex;

    @Column(name = "title")
    private String title;

    @Column(name = "disctiption")
    private String content;

    @Column(name = "price")
    private int price;

    @Column(name="create_date")
    private LocalDateTime createdDatetime = LocalDateTime.now();


   /* @Column(name = "rangetown")
    private String rangeTown;

    @Column(name = "like")
    private int like;

    @Column(name = "userindex")
    private int userIndex;
*/
    @Column(name = "fileindex")
    private int fileIndex;

    @Column(name = "categoryindex" )
    private int categoryIndex;

    @Column(name = "userindex")
    private int userIndex;

    @Builder
    public PostEntity(int postIndex,String title,String content,int price,int fileIndex,int categoryIndex,int userIndex){
        this.postIndex = postIndex;
        this.title = title;
        this.content = content;
        this.price = price;
        this.fileIndex = fileIndex;
        this.categoryIndex = categoryIndex;
        this.userIndex = userIndex;
    }

}
