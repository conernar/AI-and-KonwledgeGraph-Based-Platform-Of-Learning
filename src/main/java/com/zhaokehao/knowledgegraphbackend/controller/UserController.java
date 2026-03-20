package com.zhaokehao.knowledgegraphbackend.controller;

import com.zhaokehao.knowledgegraphbackend.common.result.Result;
import com.zhaokehao.knowledgegraphbackend.entity.User;
import com.zhaokehao.knowledgegraphbackend.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * create a User
     * @param user User
     * @return result
     */
    @PostMapping
    public Result<Void> save(@RequestBody User user){
        boolean saveSuccess = userService.save(user);
        if(!saveSuccess){
            return Result.error("Fail to add User");
        }
        return Result.success();
    }

    /**
     * update by id
     * @param user User
     * @return success
     */
    @PutMapping
    public Result<Void> update(@RequestBody User user){

        return userService.updateById(user) ? Result.success() : Result.error("failed to update");

    }

    /**
     * select one user
     */
    @GetMapping("/{id}")
    public Result<User> getOne(@PathVariable Long id){
        return Result.success(userService.getById(id));
    }

    /**
     *
     * @return list of user
     */
    @GetMapping
    public Result<List<User>> list(){
        return Result.success(userService.list());
    }

    /**
     * remove user by id
     * @param id userId
     * @return result
     */

    @DeleteMapping("/{id}")
    public Result<Void> deleteById(@PathVariable Long id){
        return userService.removeById(id) ? Result.success() : Result.error("failed to remove");
    }
}
