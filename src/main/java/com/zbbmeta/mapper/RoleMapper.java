package com.zbbmeta.mapper;

import com.zbbmeta.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author zbb
* @description 针对表【pe_role】的数据库操作Mapper
* @createDate 2023-12-07 22:11:52
* @Entity com.zbbmeta.entity.Role
*/
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> queryRoleListByUserId(@Param("id") Long id);
}




