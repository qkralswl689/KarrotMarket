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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

   /* //세션에 저장된 유저 값을 불러온다.
    User sessionUser = (User)session.getAttribute("ConfirmUser");

    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");

    String[] inserDateValue = request.getParameter("writedate").split("-");
    Calendar cal = Calendar.getInstance();
    int year = Integer.parseInt(inserDateValue[0]);
    int month = Integer.parseInt(inserDateValue[1]) - 1;
    int monthOfDay = Integer.parseInt(inserDateValue[2]);
        cal.set(year, month, monthOfDay);

    // 파일 이름을 업로드 한 날짜로 바꾸어서 저장할 것이다
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    String current_date = simpleDateFormat.format(new Date());
    String origFilename = file.getOriginalFilename();

    // 프로젝트 폴더에 저장하기 위해 절대경로를 설정 (Window 의 Tomcat 은 Temp 파일을 이용한다)

    String absolutePath = "C:\\Users\\82104\\Desktop\\MyDiaryProject\\";
        log.info("absolutePath" + new File("").getAbsolutePath());

    // 경로를 지정하고 그곳에다가 저장할 심산이다
    String path = absolutePath + "diaryimg/";
    File file1 = new File(path);
    // 저장할 위치의 디렉토리가 존지하지 않을 경우
        if (!file1.exists()) {
        // mkdir() 함수와 다른 점은 상위 디렉토리가 존재하지 않을 때 그것까지 생성
        file1.mkdirs();
    }

    // 파일들을 이제 만져볼 것이다
    // 파일이 비어 있지 않을 때 작업을 시작해야 오류가 나지 않는다
    // jpeg, png, gif 파일들만 받아서 처리할 예정
    String contentType = file.getContentType();
    String originalFileExtension = null;
    // 확장자 명이 없으면 이 파일은 잘 못 된 것이다
        if (contentType.contains("image/jpeg")) {
        originalFileExtension = ".jpg";
    } else if (contentType.contains("image/png")) {
        originalFileExtension = ".png";
    } else if (contentType.contains("image/gif")) {
        originalFileExtension = ".gif";
    }

    // 다른 파일 명이면 아무 일 하지 않는다
    // 각 이름은 겹치면 안되므로 나노 초까지 동원하여 지정
    String new_file_name = Long.toString(System.nanoTime()) + originalFileExtension;
    // 생성 후 리스트에 추가

    // 저장된 파일로 변경하여 이를 보여주기 위함
    String testString = path + new_file_name;
    file1 = new File(testString);
        log.info("absolutePath = "+ absolutePath);
        log.info("path = "+ origFilename);
        log.info("new_file_name = "+ new_file_name);
        log.info("testString = "+ testString);
        file.transferTo(file1);
        log.info("####postFile");
    DiaryFileDto diaryFileDto = new DiaryFileDto();

        diaryFileDto.setOrigFilename(origFilename);
        diaryFileDto.setFilename(new_file_name);
        diaryFileDto.setFilePath(path);

        log.info("#########################################postFile : " + diaryFileDto);
    Long fileId = fileService.saveFile(diaryFileDto);
        diaryDto.setFileId(fileId);
        diaryFileDto.setId(diaryDto.getFileId());
        diaryDto.setCreatedDate(cal.getTime());
        diaryDto.setUsername(sessionUser.getUsername());

        diaryService.saveDiary(diaryDto);
        log.info("postFile : " + diaryFileDto.getFilename());

        return "redirect:/list";*/

}
