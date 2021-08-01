package com.xxxx.server.exception;

import com.xxxx.server.pojo.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @ClassName: GlobalException
 * @Description: TODO
 * @author: solfeng
 * @date: 2021/7/8  20:26
 */
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(SQLException.class)
    public RespBean mySQLException(SQLException e){
        if (e instanceof SQLIntegrityConstraintViolationException){
            return RespBean.error("该数据有关数据，操作失败！");
        }
        return RespBean.error("数据库异常，操作失败！");
    }
    }


