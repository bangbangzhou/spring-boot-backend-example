package com.zbbmeta.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName pe_permission
 */
@TableName(value ="pe_permission")
@Data
public class Permission implements Serializable {
    private String id;

    private String name;

    private String code;

    private String description;

    private static final long serialVersionUID = 1L;
}