package com.example.bookstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bookstore.entity.Comment;
import com.example.bookstore.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    @Select("select * from comment where book_id=#{id}")
    @Results({
//            多表查询，这里结果为1对1，所以是ONE  @One
            @Result(column = "user_id",property = "userId"),
//            @Result(column = "user_id", property = "user", javaType = User.class,
//            one=@One(select = "com.example.bookstore.mapper.UserMapper.getUserById"))
            @Result(column="user_id",property = "userName",
            one=@One(select = "com.example.bookstore.mapper.UserMapper.getUserNameById")
            )
    })
    public List<Comment> getCommentByBookId(int id);
}
