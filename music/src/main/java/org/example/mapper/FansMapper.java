package org.example.mapper;

import org.example.entity.Fans;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author adm
* @description 针对表【fans(粉丝关注表)】的数据库操作Mapper
* @createDate 2022-08-24 19:03:48
* @Entity org.example.entity.Fans
*/@Repository

public interface FansMapper extends BaseMapper<Fans> {

}




