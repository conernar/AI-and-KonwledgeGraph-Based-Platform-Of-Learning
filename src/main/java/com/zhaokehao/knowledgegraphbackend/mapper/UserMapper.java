package com.zhaokehao.knowledgegraphbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhaokehao.knowledgegraphbackend.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
