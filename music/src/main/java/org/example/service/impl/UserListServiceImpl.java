package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.UserList;
import org.example.service.UserListService;
import org.example.mapper.UserListMapper;
import org.springframework.stereotype.Service;

/**
* @author adm
* @description 针对表【user_list(用户收藏歌单表)】的数据库操作Service实现
* @createDate 2022-08-24 19:12:44
*/
@Service
public class UserListServiceImpl extends ServiceImpl<UserListMapper, UserList>
    implements UserListService{

}




