package com.zbbmeta.mapper;

import com.zbbmeta.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author zbb
* @description 针对表【pe_user】的数据库操作Mapper
* @createDate 2023-12-07 22:12:04
* @Entity com.zbbmeta.entity.User
*/
public interface UserMapper extends BaseMapper<User> {

    User findByUsername(String name);
}




