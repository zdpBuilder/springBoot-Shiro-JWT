package com.zdp.jwt.controller;


import com.zdp.jwt.domain.ResultDto;
import com.zdp.jwt.mapper.UserMapper;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zdp
 * @description: 角色权限Controller
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final UserMapper userMapper;


    @Autowired
    public AdminController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/getUser")
    @RequiresRoles("admin")
    public ResultDto getUser() {

        return ResultDto.success(userMapper.getUser());
    }

    /**
     * 封号操作
     */
    @PostMapping("/banUser")
    @RequiresRoles("admin")
    public ResultDto updatePassword(String username) {
        userMapper.banUser(username);
        return ResultDto.success("成功封号！");
    }
}
