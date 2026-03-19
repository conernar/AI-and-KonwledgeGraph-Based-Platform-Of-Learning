package com.zhaokehao.knowledgegraphbackend.controller;

import com.zhaokehao.knowledgegraphbackend.common.result.Result;
import com.zhaokehao.knowledgegraphbackend.entity.User;
import com.zhaokehao.knowledgegraphbackend.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping
    public Result<Void> save(@RequestBody User user){
        boolean saveSuccess = userService.save(user);
        if(!saveSuccess){
            return Result.error("Fail to add User");
        }
        return Result.success();
    }
}
