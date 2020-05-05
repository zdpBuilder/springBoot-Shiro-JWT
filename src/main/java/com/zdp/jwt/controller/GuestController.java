package com.zdp.jwt.controller;


import com.zdp.jwt.domain.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zdp
 * @description: 游客访问Controller
 */
@RestController
@RequestMapping("/guest")
public class GuestController {


    @GetMapping("/welcome")
    public ResultDto login() {
        return ResultDto.success("欢迎访问游客页面！");
    }
}
