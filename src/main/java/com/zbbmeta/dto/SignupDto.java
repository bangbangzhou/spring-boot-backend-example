package com.zbbmeta.dto;

import lombok.Data;

import java.util.List;

/**
 * @author springboot葵花宝典
 * @description: 注册
 */
@Data
public class SignupDto {



    private String username;



    private String email;

    private List<String> role;


    private String password;
}
