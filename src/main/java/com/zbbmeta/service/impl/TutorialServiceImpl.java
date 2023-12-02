package com.zbbmeta.service.impl;

import cn.hutool.core.lang.intern.InternUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbbmeta.entity.Tutorial;
import com.zbbmeta.mapper.TutorialMapper;
import com.zbbmeta.service.TutorialService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
* @author zhou.bangbang
* @description 针对表【tb_tutorial】的数据库操作Service实现
* @createDate 2023-11-30 12:52:22
*/
@Service
public class TutorialServiceImpl extends ServiceImpl<TutorialMapper, Tutorial>
    implements TutorialService{



    @Override
    public List<Tutorial> findByTutorialCondition(Tutorial tutorial) {


        LambdaQueryWrapper<Tutorial> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StrUtil.isNotEmpty(tutorial.getTitle()),Tutorial::getTitle,tutorial.getTitle());
        wrapper.eq(Objects.nonNull(tutorial.getPublished()) ,Tutorial::getPublished,tutorial.getPublished());
        wrapper.like(StrUtil.isNotEmpty(tutorial.getDescription()),Tutorial::getDescription,tutorial.getDescription());

        return this.baseMapper.selectList(wrapper);

    }


//    @Override
//    public Page findPageByTutorialCondition(Tutorial tutorial) {
//
//
//        LambdaQueryWrapper<Tutorial> wrapper = new LambdaQueryWrapper<>();
//        wrapper.like(StrUtil.isNotEmpty(tutorial.getTitle()),Tutorial::getTitle,tutorial.getTitle());
//        wrapper.eq(Objects.nonNull(tutorial.getPublished()) ,Tutorial::getPublished,tutorial.getPublished());
//        wrapper.like(StrUtil.isNotEmpty(tutorial.getDescription()),Tutorial::getDescription,tutorial.getDescription());
//        try{
//            Page page = this.baseMapper.selectPage(tutorial.getPage(), wrapper);
//        }catch (Exception e){
//            System.err.println(e.getMessage());
//        }
//
//        return this.baseMapper.selectPage(tutorial.getPage(),wrapper);
//
//    }
}




