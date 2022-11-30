package com.example.bookstore.controller;

import com.example.bookstore.entity.Category;
import com.example.bookstore.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryMapper categoryMapper;
    @Autowired
    public CategoryController(CategoryMapper categoryMapper){
        this.categoryMapper=categoryMapper;
    }
    @GetMapping("/category")
    public List listAllCategories(){
        return categoryMapper.listAllCategories(0);
    }
//    @GetMapping("/category/{id}")
//    public Category getCategoryById(@PathVariable int id){
//        return categoryMapper.selectById(id);
//    }
}

