package com.example.bookstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.Introduction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface IntroductionMapper extends BaseMapper<Introduction> {
    //    @Select("select * from introduction where book_id=#{id}")
//    public List<Introduction> getIntroductionByBookId(int id);
    @Select("select content from introduction where book_id=#{id}")
    public String getIntroductionByBookId(int id);
}
