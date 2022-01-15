package com.karrot.karrotmarket.post.service;

import com.karrot.karrotmarket.post.entity.PostEntity;
import com.karrot.karrotmarket.post.entity.PostFileEntity;
import com.karrot.karrotmarket.post.service.PostService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Override
    public List<PostEntity> selectBoardList() throws Exception {
        return null;
    }

    @Override
    public void saveBoard(PostEntity post, MultipartHttpServletRequest multipartHttpServletRequest, int hitCnt) throws Exception {

    }

    @Override
    public PostEntity selectPostDetail(int postIndex) throws Exception {
        return null;
    }

    @Override
    public void deletePost(int postIndex) throws Exception {

    }

    @Override
    public PostFileEntity selectPostFileInformation(int fileIndex, int postIndex) throws Exception {
        return null;
    }

    @Override
    public void deletePostFile(int fileIndex, int postIndex) throws Exception {

    }
}
