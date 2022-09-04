package org.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.entity.User;
import org.example.entity.vo.UserParam;
import org.example.exception.service.ServiceException;
import org.example.mapper.UserMapper;
import org.example.service.UserService;
import org.example.util.PageUtil;
import org.example.util.UserThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public IPage<User> selectListByPage(UserParam userParam) {
        return userMapper.selectPage(new Page<>(PageUtil.page(), PageUtil.pageSize()), null);
    }

    @Override
    public int update(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public int updatePassword(String oldPassword, String newPassword) {
        if (!bCryptPasswordEncoder.matches(oldPassword, UserThreadLocal.getUser().getPassword())) {
            throw new ServiceException("旧密码错误");
        }
        return userMapper.updateById(new User()
            .setId(UserThreadLocal.getUser().getId())
            .setPassword(bCryptPasswordEncoder.encode(newPassword)));
    }
}
