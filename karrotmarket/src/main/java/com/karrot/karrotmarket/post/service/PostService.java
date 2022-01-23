package com.karrot.karrotmarket.post.service;

import com.karrot.karrotmarket.post.dto.PostDto;
import com.karrot.karrotmarket.file.entity.FileEntity;
import com.karrot.karrotmarket.post.entity.PostEntity;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface PostService {

    int savePost(PostDto postDto);

    PostDto getPost(int postIndex);

    List<PostEntity> getPosts() throws Exception;


    PostDto selectPostDetail(int postIndex) throws Exception;

    void deletePost(int postIndex) throws Exception;

    FileEntity selectPostFileInformation(int fileIndex, int postIndex) throws Exception;

    void deletePostFile(int fileIndex, int postIndex) throws Exception;
}
