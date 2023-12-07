package com.zbbmeta.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zbbmeta.api.Result;
import com.zbbmeta.api.ResultCode;
import com.zbbmeta.dto.LoginDto;
import com.zbbmeta.dto.SignupDto;
import com.zbbmeta.entity.Permission;
import com.zbbmeta.entity.Role;
import com.zbbmeta.entity.User;
import com.zbbmeta.entity.UserRole;
import com.zbbmeta.service.RoleService;
import com.zbbmeta.service.UserRoleService;
import com.zbbmeta.service.UserService;
import com.zbbmeta.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author springboot葵花宝典
 * @description: TODO
 */
@RequestMapping("/api/auth")
@RestController
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    UserRoleService userRoleService;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signin")
    public Result authenticateUser(@RequestBody LoginDto loginDto) {
        //根据用户名查找用户
        User user = userService.findByName(loginDto.getUsername());
        //不存在表示登录失败
        if(Objects.isNull(user)){
            return Result.FAIL(ResultCode.USERNOEXIT_ERROR);
        }
        //密码不同登录失败
        if(!passwordEncoder.matches(loginDto.getPassword(),user.getPassword())){
            return Result.FAIL(ResultCode.PASSWORD_ERROR);
        }
        List<String> collect = user.getRoles().stream().map(x -> x.getName()).collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
        List<Role> roles = user.getRoles();
        for (Role role : roles) {
            List<Permission> permissions = role.getPermissions();
            for (Permission permission : permissions) {

                builder.append(permission.getCode()).append(",");
            }
        }
        Map<String, Object> map  = new HashMap<>();
        map.put("username",user.getUsername());
        map.put("permission",builder);
        String token = jwtUtil.createJwt(user.getId(), user.getUsername(), map);

        return Result.SUCCESS(token);
    }



    /**
     * 用户注册
     * @param signupDto
     * @return
     */
    @PostMapping("/signup")
    public Result registerUser( @RequestBody SignupDto signupDto){
        //根据用户名获取用户
        User user = userService.findByName(signupDto.getUsername());
        //用户不是null表示用户已经存在
        if(Objects.nonNull(user)){
            return Result.FAIL(ResultCode.USER_ERROR);
        }
        //添加用户
        User user1 = new User();
        user1.setUsername(signupDto.getUsername());
        user1.setPassword(signupDto.getPassword());

        user1.setPassword(passwordEncoder.encode(signupDto.getPassword()));

        List<String> strRoles = signupDto.getRole();
        List<Role> roles = new ArrayList<>();
        //如果没有用户角色，默认添加普通员工
        if (strRoles == null) {
            LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Role::getName,"普通员工");
            Role role = roleService.getOne(wrapper);
            roles.add(role);
        }else {
            strRoles.forEach(role ->{
                LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<>();
                wrapper.eq(Role::getName,role);
                Role adminRole = roleService.getOne(wrapper);
                roles.add(adminRole);
            });

        }
        //添加用户信息
        boolean save = userService.save(user1);
        String id = user1.getId();

        List<UserRole> userRolesList = new ArrayList<>();
        for (Role role : roles) {
            UserRole userRoles = new UserRole();
            userRoles.setUserId(id);
            userRoles.setRoleId(role.getId());
            userRolesList.add(userRoles);
        }
        //添加用户和角色关系
        userRoleService.saveBatch(userRolesList);
        return Result.SUCCESS("注册成功!");

    }
}
