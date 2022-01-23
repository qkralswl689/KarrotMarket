package com.karrot.karrotmarket.post.service;

import com.karrot.karrotmarket.post.dto.PostDto;
import com.karrot.karrotmarket.file.entity.FileEntity;
import com.karrot.karrotmarket.post.entity.PostEntity;
import com.karrot.karrotmarket.post.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository repository){
        this.postRepository = repository;
    }

    @Transactional
    @Override
    public int savePost(PostDto postDto) {
        return postRepository.save(postDto.toEntity()).getPostIndex();
    }

    @Transactional
    @Override
    public PostDto getPost(int postIndex) {
        PostEntity post = postRepository.findById(postIndex).get();

        PostDto postDto = PostDto.builder()
                .postIndex(post.getPostIndex())
                .title(post.getTitle())
                .content(post.getContent())
                .fileIndex(post.getFileIndex())
                .createdDatetime(post.getCreatedDatetime())
                .build();
        return postDto;
    }

    @Override
    public List<PostEntity> getPosts() throws Exception {

        List<PostEntity> postList = (List<PostEntity>) postRepository.findAll();
        return postList;
    }



    @Override
    public PostDto selectPostDetail(int postIndex) throws Exception {
        return null;
    }

    @Override
    public void deletePost(int postIndex) throws Exception {

    }

    @Override
    public FileEntity selectPostFileInformation(int fileIndex, int postIndex) throws Exception {
        return null;
    }

    @Override
    public void deletePostFile(int fileIndex, int postIndex) throws Exception {

    }
}
