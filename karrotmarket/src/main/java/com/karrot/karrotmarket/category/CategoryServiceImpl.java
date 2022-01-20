package com.karrot.karrotmarket.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

     CategoryRepository categoryRepository;


    @Transactional
    @Override
    public int saveCategory(CategoryDto categoryDto) {

        return categoryRepository.save(categoryDto.toEntity()).getCaid();
    }


}
