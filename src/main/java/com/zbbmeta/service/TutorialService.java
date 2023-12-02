package com.zbbmeta.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zbbmeta.entity.Tutorial;

import java.util.List;

/**
* @author zhou.bangbang
* @description 针对表【tb_tutorial】的数据库操作Service
* @createDate 2023-11-30 12:52:22
*/
public interface TutorialService extends IService<Tutorial> {
    List<Tutorial> findByTutorialCondition(Tutorial tutorial);

}
