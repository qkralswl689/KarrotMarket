package com.karrot.karrotmarket.post.controller;

import com.karrot.karrotmarket.category.CategoryDto;
import com.karrot.karrotmarket.category.CategoryEntity;
import com.karrot.karrotmarket.category.CategoryServiceImpl;
import com.karrot.karrotmarket.file.MD5Generator;
import com.karrot.karrotmarket.file.dto.FileDto;
import com.karrot.karrotmarket.file.service.FileService;
import com.karrot.karrotmarket.file.service.FileServiceImpl;
import com.karrot.karrotmarket.post.dto.PostDto;
import com.karrot.karrotmarket.post.entity.PostEntity;
import com.karrot.karrotmarket.post.service.PostServiceImpl;
import com.karrot.karrotmarket.user.dto.UserDto;
import com.karrot.karrotmarket.user.entity.UserEntity;
import com.karrot.karrotmarket.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.parser.Parser;
import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
public class PostController {

    private PostServiceImpl postService;
    private FileServiceImpl fileService;
    private CategoryServiceImpl categoryService;
    private UserServiceImpl userService;

    public PostController(PostServiceImpl postService, FileServiceImpl fileService,CategoryServiceImpl categoryService,UserServiceImpl userService){
        this.postService = postService;
        this.fileService = fileService;
        this.categoryService = categoryService;
        this.userService = userService;
    }
    @PostMapping("/post")
    public String write(@RequestParam("file") MultipartFile files, PostDto postDto , @RequestParam("category")  int caid, HttpServletRequest request, HttpSession session, Model model ){
        //세션에 저장된 유저 값을 불러온다.
        String sessionUser = (String) session.getAttribute("email");



        try {
            String origFilename = files.getOriginalFilename();
            String filename = new MD5Generator(origFilename).toString();
             //실행되는 위치의 'files' 폴더에 파일이 저장됩니다.
            String savePath = System.getProperty("user.dir") + "\\files";
             //파일이 저장되는 폴더가 없으면 폴더를 생성합니다.
            if (!new File(savePath).exists()) {
                try{
                    new File(savePath).mkdir();
                }
                catch(Exception e){
                    e.getStackTrace();
                }
            }


            String filePath = savePath + "\\" + filename;
            files.transferTo(new File(filePath));

            FileDto fileDto = new FileDto();
            fileDto.setFileOriginName(origFilename);
            fileDto.setFileName(filename);
            fileDto.setFilePath(filePath);


            int categoryIndex = caid;
            int fileIndex = fileService.saveFile(fileDto);
            int user = Math.toIntExact(userService.getUserIndex(sessionUser).getUsertIdx());

            postDto.setFileIndex(fileIndex);
            postDto.setUserindex(user);
            postDto.setCategoryIndex(categoryIndex);
            postService.savePost(postDto);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "redirect:/home";

    }

    @GetMapping("/home/read")
    public String read(Model model,HttpSession session) throws Exception {
        String sessionUser = (String) session.getAttribute("email");
        model.addAttribute("loginUser",sessionUser);
        int userIndex = Math.toIntExact(userService.getUserIndex(sessionUser).getUsertIdx());


        List<PostEntity> posts = postService.getPosts();

        FileDto fileDto = new FileDto();


        int fileIndex = fileDto.getFileIndex();

        FileDto fileList = fileService.getFile(fileIndex);

        fileDto.setFileName(fileList.getFileName());
        fileDto.setFileOriginName(fileList.getFileOriginName());
        fileDto.setFilePath(fileList.getFilePath());

        model.addAttribute("post",posts);
        model.addAttribute("postFile",fileList);

        return "/home";

    }
}
