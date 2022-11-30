package com.example.bookstore.controller;

import com.example.bookstore.entity.User;
import com.example.bookstore.exception.BaseException;
import com.example.bookstore.mapper.UserMapper;
import com.example.bookstore.response.ResponseData;
import com.example.bookstore.utils.ResponseDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping(value = "/user")
    public ResponseData listAllUsers(){
        List list=userMapper.selectList(null);
        return ResponseDataUtil.buildSuccess(list);
    }
    @RequestMapping("/user/{id}")
    public ResponseData getUserById(@PathVariable int id){
        return ResponseDataUtil.buildSuccess(userMapper.getUserById(id));
    }
    @RequestMapping("/user/register")
    public ResponseData registerUser(@RequestBody User user)  throws  BaseException{
        int uId;
        try{ uId=userMapper.insert(user);}
        catch (Exception e){
            //抛出BaseException由GlobalExceptionHandler处理
            throw new BaseException("500","error in register!");
        }
        if(!"null".equals(String.valueOf(uId))||uId!=-1)
        {//注册成功
            return ResponseDataUtil.buildSuccess(userMapper.getUserById(user.getUserId()));
        }
        else{//注册失败
            throw new BaseException("400","error in register!");
//           return ResponseDataUtil.buildError("400","error in register");
        }
    }
    @RequestMapping("/user/login")
    public ResponseData login(@RequestBody User user) throws BaseException{
        User tempUser= userMapper.isLogin(user);

        if(tempUser==null){//用户名密码错误，没有返回数据
            throw new BaseException("400","error in username or password!");
//            return ResponseDataUtil.buildError("400","error in username or password!");
        }
        else {
            return ResponseDataUtil.buildSuccess("200","login success!",tempUser);
        }
    }

}
