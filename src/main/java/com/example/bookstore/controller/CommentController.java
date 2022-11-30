package com.example.bookstore.controller;

import com.example.bookstore.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentMapper commentMapper;
    @GetMapping("/book/{id}/comment")
    public List getCommentByBookId(@PathVariable int id){
    return commentMapper.getCommentByBookId(id);
    }
}
