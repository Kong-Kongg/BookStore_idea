package com.example.bookstore.exception;

import com.example.bookstore.response.ResponseData;
import com.example.bookstore.utils.ResponseDataUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice
public class GlobalExceptionHandler<T> {

    @ResponseBody
    @ExceptionHandler(value = BaseException.class)
    public ResponseData  runtimeException(BaseException e) {
        return ResponseDataUtil.buildError(e.getErrorCode(),e.getErrorMsg());
    }

}