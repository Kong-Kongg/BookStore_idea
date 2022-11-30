package com.example.bookstore.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.Category;
import com.example.bookstore.mapper.BookMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    public BookMapper bookMapper;//绑定和使用BookMapper对象

    @GetMapping("/book")
    public List listAllBooks() {
        List books = bookMapper.selectList(null);
        System.out.println(books);
        return books;
    }

    @GetMapping("/book/hot")
    public List listHottestBooks() {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hottest", "1");
        List books = bookMapper.selectList(queryWrapper);
        return books;
    }
    @GetMapping("/book/new")
    public List listNewestBooks() {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("newest", "1");
        List books = bookMapper.selectList(queryWrapper);
        return books;
    }
    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable int id){
        return bookMapper.selectById(id);
    }
    // http://XXX/search?keyword=XXX根据keyword查询结果
    @GetMapping("/search")
    public List searchBooks(String keyword){
        //select * from book where title like XXX or author like XXX or brief like XXX or book_concern like XXX
            QueryWrapper<Book> queryWrapper=new QueryWrapper<>();
            queryWrapper.like("title",keyword);
            queryWrapper.or();
            queryWrapper.like("author",keyword);
            queryWrapper.or();
            queryWrapper.like("brief",keyword);
            queryWrapper.or();
            queryWrapper.like("book_concern",keyword);
            List books=bookMapper.selectList(queryWrapper);
            return books;
    }

    @GetMapping("/category/{id}")
    public List getCategoryById(@PathVariable int id){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_id", id);
        List books = bookMapper.selectList(queryWrapper);
        return books;
    }
}
