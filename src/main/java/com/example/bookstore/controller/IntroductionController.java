package com.example.bookstore.controller;

import com.example.bookstore.mapper.IntroductionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IntroductionController {
    @Autowired
    private IntroductionMapper introductionMapper;
    @GetMapping("/book/{id}/introduction")
//    public List getIntroductionByBookId(@PathVariable int id){
//        return introductionMapper.getIntroductionByBookId(id);
//    }
    public String getIntroductionByBookId(@PathVariable int id){
        return introductionMapper.getIntroductionByBookId(id);
    }
}