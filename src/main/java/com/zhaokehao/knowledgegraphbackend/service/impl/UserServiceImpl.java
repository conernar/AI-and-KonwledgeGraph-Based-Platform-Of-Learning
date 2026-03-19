package com.zhaokehao.knowledgegraphbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhaokehao.knowledgegraphbackend.entity.User;
import com.zhaokehao.knowledgegraphbackend.mapper.UserMapper;
import com.zhaokehao.knowledgegraphbackend.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
