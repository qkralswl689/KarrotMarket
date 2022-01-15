package com.karrot.karrotmarket.post.service;

import com.karrot.karrotmarket.post.entity.PostEntity;
import com.karrot.karrotmarket.post.entity.PostFileEntity;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface PostService {

    List<PostEntity> selectBoardList() throws Exception;

    void saveBoard(PostEntity post, MultipartHttpServletRequest multipartHttpServletRequest, int hitCnt) throws Exception;

    PostEntity selectPostDetail(int postIndex) throws Exception;

    void deletePost(int postIndex) throws Exception;

    PostFileEntity selectPostFileInformation(int fileIndex, int postIndex) throws Exception;

    void deletePostFile(int fileIndex, int postIndex) throws Exception;
}
