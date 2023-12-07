package com.zbbmeta.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbbmeta.entity.Permission;
import com.zbbmeta.entity.Role;
import com.zbbmeta.entity.User;
import com.zbbmeta.service.UserService;
import com.zbbmeta.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author zbb
* @description 针对表【pe_user】的数据库操作Service实现
* @createDate 2023-12-07 22:12:04
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User findByName(String name) {
        return userMapper.findByUsername(name);
    }


}




