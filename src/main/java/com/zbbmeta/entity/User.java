package com.zbbmeta.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * @TableName pe_user
 */
@TableName(value ="pe_user")
@Data
public class User implements Serializable {
    private String id;

    private String username;

    private String password;
    @TableField(exist = false)
    private List<Role> roles = new ArrayList<>();//用户与角色   多对多


    private static final long serialVersionUID = 1L;
}