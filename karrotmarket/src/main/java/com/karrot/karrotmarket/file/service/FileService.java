package com.karrot.karrotmarket.file.service;

import com.karrot.karrotmarket.file.dto.FileDto;

public interface FileService {

    public int saveFile(FileDto fileDto);

    public FileDto getFile(int fileIndex);
}
