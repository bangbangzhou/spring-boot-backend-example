package com.zbbmeta.service.impl;

import com.zbbmeta.entity.Permission;
import com.zbbmeta.entity.Role;
import com.zbbmeta.entity.User;
import com.zbbmeta.service.UserService;
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
 * @author springboot葵花宝典
 * @description: TODO
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByName(username);
        List<Role> roles = user.getRoles();
        List<String> authorities = new ArrayList<>();
        for (Role role : roles) {
            List<Permission> permissions = role.getPermissions();

            List<String> collect = permissions.stream().map(x -> x.getCode()).distinct().collect(Collectors.toList());
            authorities.addAll(collect);
        }


        List<String> collect1 = authorities.stream().distinct().collect(Collectors.toList());
        return   new org.springframework.security.core.userdetails.User(username, user.getPassword(), AuthorityUtils.createAuthorityList(collect1.toString()));

    }
}
