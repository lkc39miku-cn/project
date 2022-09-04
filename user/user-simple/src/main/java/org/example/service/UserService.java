package org.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.entity.User;
import org.example.entity.vo.UserParam;

public interface UserService {
    IPage<User> selectListByPage(UserParam userParam);

    int update(User user);

    int updatePassword(String oldPassword, String newPassword);
}
