package com.karrot.karrotmarket.file.repository;

import com.karrot.karrotmarket.file.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity,Integer> {
}
