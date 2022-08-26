package org.example.mapper;

import org.example.entity.UserList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author adm
* @description 针对表【user_list(用户收藏歌单表)】的数据库操作Mapper
* @createDate 2022-08-24 19:12:44
* @Entity org.example.entity.UserList
*/@Repository

public interface UserListMapper extends BaseMapper<UserList> {

}




