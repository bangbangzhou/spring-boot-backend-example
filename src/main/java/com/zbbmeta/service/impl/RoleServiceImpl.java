package com.zbbmeta.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbbmeta.entity.Role;
import com.zbbmeta.service.RoleService;
import com.zbbmeta.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author zbb
* @description 针对表【pe_role】的数据库操作Service实现
* @createDate 2023-12-07 22:11:52
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




