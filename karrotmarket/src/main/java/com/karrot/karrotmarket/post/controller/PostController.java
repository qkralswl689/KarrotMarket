package com.karrot.karrotmarket.post.controller;

import com.karrot.karrotmarket.file.MD5Generator;
import com.karrot.karrotmarket.file.dto.FileDto;
import com.karrot.karrotmarket.file.service.FileService;
import com.karrot.karrotmarket.file.service.FileServiceImpl;
import com.karrot.karrotmarket.post.dto.PostDto;
import com.karrot.karrotmarket.post.service.PostServiceImpl;
import com.karrot.karrotmarket.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
public class PostController {

    private PostServiceImpl postService;
    private FileServiceImpl fileService;

    public PostController(PostServiceImpl postService, FileServiceImpl fileService){
        this.postService = postService;
        this.fileService = fileService;
    }
    @PostMapping("/post")
    public String write(@RequestParam("file") MultipartFile files, PostDto postDto , HttpServletRequest request, HttpSession session, Model model ){
        //세션에 저장된 유저 값을 불러온다.
        UserEntity sessionUser = (UserEntity)session.getAttribute("ConfirmUser");
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

            int fileIndex = fileService.saveFile(fileDto);
            postDto.setFileIndex(fileIndex);
            postService.savePost(postDto);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";

    }
 /*   @PostMapping("/post")
    public String write( PostDto postDto ){
       *//* //세션에 저장된 유저 값을 불러온다.
        UserEntity sessionUser = (UserEntity)session.getAttribute("ConfirmUser");*//*
        try {

            postService.savePost(postDto);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";

    }*/
/*    @PostMapping("/upload")
    public String uploadFile(@RequestParam MultipartFile[] uploadFiles, Model model) throws IOException {

        List<FileDto> list = new ArrayList<>();
        for(MultipartFile file : uploadFiles){
            if(!file.isEmpty()){



            }
        }
      model.addAttribute("files",list);
        return "result";
    }*/
 @RequestMapping(value = "/url",method = RequestMethod.POST)
 public String getData(Model model, MultipartHttpServletRequest req) {

     //get image file.
     List<MultipartFile> multipartFileList = new ArrayList<>();
     try {
         MultiValueMap<String, MultipartFile> files = req.getMultiFileMap();
         for (Map.Entry<String, List<MultipartFile>> entry : files.entrySet()) {
             List<MultipartFile> fileList = entry.getValue();
             for (MultipartFile file : fileList) {
                 if (file.isEmpty()) continue;
                 multipartFileList.add(file);
             }
         }

         if (multipartFileList.size() > 0) {
             for (MultipartFile file : multipartFileList) {
                 file.transferTo(new File("/img" + File.separator + file.getOriginalFilename()));
             }
         }
     } catch (Exception e) {
         e.printStackTrace();
     }


     model.addAttribute("log", "사진 " + multipartFileList.size() + "장 전송완료!");
     return "html템플릿 주소 :: #resultDiv";
 }

}
