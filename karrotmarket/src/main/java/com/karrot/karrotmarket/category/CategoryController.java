package com.karrot.karrotmarket.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/salePage")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

/*    @ModelAttribute("/category")
    public List<CategoryDto> category(){
        List<CategoryDto> list = new ArrayList<>();
        list = categoryRepository.findAll();
        return list;
    }*/


    public String readCategory(Model model) {
        List<CategoryDto> list = new ArrayList<>();
        list = categoryRepository.findAll();

        model.addAttribute("list",list);
        return "/salePage";
    }


}
