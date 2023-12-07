package com.zbbmeta.mapper;

import com.zbbmeta.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author zbb
* @description 针对表【pe_permission】的数据库操作Mapper
* @createDate 2023-12-07 22:11:26
* @Entity com.zbbmeta.entity.Permission
*/
public interface PermissionMapper extends BaseMapper<Permission> {
    List<Permission> queryPermissionList(@Param("id") Long id);
}




