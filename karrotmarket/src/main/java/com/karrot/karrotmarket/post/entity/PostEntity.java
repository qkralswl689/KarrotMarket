package com.karrot.karrotmarket.post.entity;

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

    @Column(name = "discription")
    private String content;

    @Column(name = "price")
    private int price;

    @Column(name="create_date")
    private LocalDateTime createdDatetime = LocalDateTime.now();

    @Column(name = "modififelddate")
    private LocalDateTime modifyDate = LocalDateTime.now();

    @Column(name = "rangetown")
    private String rangeTown;

    @Column(name = "like")
    private int like;




}
