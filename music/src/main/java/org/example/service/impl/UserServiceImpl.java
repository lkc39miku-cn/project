package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.User;
import org.example.service.UserService;
import org.example.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author adm
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2022-08-24 19:12:39
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




