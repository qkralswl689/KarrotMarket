package com.karrot.karrotmarket.user.repository;

import com.karrot.karrotmarket.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository extends JpaRepository<UserEntity,Long> {
    public UserEntity findByEmail(String email);
    public List<UserEntity> findAll();

}
