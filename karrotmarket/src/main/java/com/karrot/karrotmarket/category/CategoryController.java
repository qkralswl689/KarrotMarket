package com.karrot.karrotmarket.category;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    private CategoryRepository categoryRepository;

    private CategoryServiceImpl categoryService;

/*    @ModelAttribute("/category")
    public List<CategoryDto> category(){
        List<CategoryDto> list = new ArrayList<>();
        list = categoryRepository.findAll();
        return list;
    }*/


    @GetMapping("/post/category")
    public String readCategory(@PathVariable("category") @NotNull Model model) {

        List<CategoryEntity > category = categoryService.getCategory();

        model.addAttribute("category",category);
        return "/salePage";
    }


}
