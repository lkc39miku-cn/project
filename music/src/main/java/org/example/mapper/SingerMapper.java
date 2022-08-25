package org.example.mapper;

import org.example.entity.Singer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author adm
* @description 针对表【singer(歌手)】的数据库操作Mapper
* @createDate 2022-08-24 19:12:09
* @Entity org.example.entity.Singer
*/@Repository

public interface SingerMapper extends BaseMapper<Singer> {

}




