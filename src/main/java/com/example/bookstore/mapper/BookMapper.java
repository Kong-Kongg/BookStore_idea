package com.example.bookstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bookstore.entity.Book;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
