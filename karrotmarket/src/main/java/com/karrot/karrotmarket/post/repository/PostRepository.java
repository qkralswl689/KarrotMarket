package com.karrot.karrotmarket.post.repository;

import com.karrot.karrotmarket.post.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostEntity,Integer> {
}
