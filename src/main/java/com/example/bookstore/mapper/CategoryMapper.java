package com.example.bookstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bookstore.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
    @Select("select * from book_category where  parent_id =#{id}  ")
    @Results({
//            多表查询，这里结果为1对n，所以是many=  @Many
            @Result(column = "category_id",property = "categoryId"),
            @Result(column="category_id",property = "children",
                    many=@Many(select = "com.example.bookstore.mapper.CategoryMapper.listAllCategories")
            )
    })
    public List<Category> listAllCategories(int id);

    @Select("select * from book_category where categoryId=#{categoryId}")
    public Category getCategoryById(int categoryId);

}
