package com.karrot.karrotmarket.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class CategoryServiceImpl implements CategoryService{

     CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity >getCategory() {

        List<CategoryEntity> category = new ArrayList<>();
        category = categoryRepository.findAll();

        return category;
    }
}
