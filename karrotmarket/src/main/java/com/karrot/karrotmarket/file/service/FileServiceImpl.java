package com.karrot.karrotmarket.file.service;

import com.karrot.karrotmarket.file.dto.FileDto;
import com.karrot.karrotmarket.file.entity.FileEntity;
import com.karrot.karrotmarket.file.repository.FileRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FileServiceImpl implements FileService{

    private FileRepository fileRepository;

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Transactional
    @Override
    public int saveFile(FileDto fileDto) {
        return fileRepository.save(fileDto.toEntity()).getFileNo();
    }

    @Transactional
    @Override
    public FileDto getFile(int fileIndex) {
        FileEntity file = fileRepository.findById(fileIndex).get();

        FileDto fileDto = FileDto.builder()
                .fileIndex(fileIndex)
                .fileOriginName(file.getFileOriginName())
                .fileName(file.getFileName())
                .filePath(file.getFilePath())
                .build();
        return fileDto;
    }
}
