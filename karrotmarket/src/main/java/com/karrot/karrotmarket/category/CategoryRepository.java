package com.karrot.karrotmarket.category;

import com.karrot.karrotmarket.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

    public List<CategoryEntity> findAll();
}
