package org.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.entity.User;
import org.example.entity.vo.UserParam;
import org.example.mapper.UserMapper;
import org.example.service.UserService;
import org.example.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<User> selectListByPage(UserParam userParam) {
        return userMapper.selectPage(new Page<>(PageUtil.page(), PageUtil.pageSize()), null);
    }

    @Override
    public int update(User user) {
        return userMapper.updateById(user);
    }
}
