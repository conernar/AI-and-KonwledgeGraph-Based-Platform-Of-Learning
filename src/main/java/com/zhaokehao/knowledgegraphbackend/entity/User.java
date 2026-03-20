package com.zhaokehao.knowledgegraphbackend.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_user")
public class User {

    @TableId(type = IdType.AUTO)
    private Long userId;

    @TableField("username")
    private String userName;

    private String password;

    private String realName;

    private String studentId;

    private String major;

    private String email;

    private String phone;

    private String avatar;

    private Integer status;

    private Long roleId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
