package com.example.bookstore.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("introduction")
public class Introduction {
    private Integer id;
    private int bookId;
    private  String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {return bookId;}
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
