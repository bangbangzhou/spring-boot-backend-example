package com.zbbmeta.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName pe_user_role
 */
@TableName(value ="pe_user_role")
@Data
public class UserRole implements Serializable {
    private String roleId;

    private String userId;

    private static final long serialVersionUID = 1L;
}