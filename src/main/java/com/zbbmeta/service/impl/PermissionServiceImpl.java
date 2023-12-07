package com.zbbmeta.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbbmeta.entity.Permission;
import com.zbbmeta.service.PermissionService;
import com.zbbmeta.mapper.PermissionMapper;
import org.springframework.stereotype.Service;

/**
* @author zbb
* @description 针对表【pe_permission】的数据库操作Service实现
* @createDate 2023-12-07 22:11:26
*/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
    implements PermissionService{

}




