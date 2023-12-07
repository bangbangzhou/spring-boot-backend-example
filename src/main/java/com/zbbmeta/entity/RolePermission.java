package com.zbbmeta.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName pe_role_permission
 */
@TableName(value ="pe_role_permission")
@Data
public class RolePermission implements Serializable {
    private String roleId;

    private String permissionId;

    private static final long serialVersionUID = 1L;
}