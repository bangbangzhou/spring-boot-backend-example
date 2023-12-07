package com.zbbmeta.service;

import com.zbbmeta.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author zbb
* @description 针对表【pe_user】的数据库操作Service
* @createDate 2023-12-07 22:12:04
*/
public interface UserService extends IService<User> {
    User findByName(String name);
}
