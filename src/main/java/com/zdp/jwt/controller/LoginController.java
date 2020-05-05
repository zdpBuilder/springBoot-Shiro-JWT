package com.zdp.jwt.controller;


import com.zdp.jwt.domain.ResultDto;
import com.zdp.jwt.mapper.UserMapper;
import com.zdp.jwt.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

/**
 * @author zdp
 * @description: 登录Controller
 */
@RestController
public class LoginController {
    private final UserMapper userMapper;


    @Autowired
    public LoginController(UserMapper userMapper ) {
        this.userMapper = userMapper;

    }

    @PostMapping("/login")
    public ResultDto login(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        String realPassword = userMapper.getPassword(username);
        if (realPassword == null) {
            return ResultDto.error("用户名错误");
        } else if (!realPassword.equals(password)) {
            return ResultDto.error("密码错误");
        } else {
            return ResultDto.success(JWTUtils.createToken(username));
        }
    }

    @RequestMapping(path = "/unauthorized/{message}")
    public ResultDto unauthorized(@PathVariable String message) throws UnsupportedEncodingException {
        return ResultDto.auth(message);
    }
}
