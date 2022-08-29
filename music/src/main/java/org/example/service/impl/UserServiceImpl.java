package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.entity.*;
import org.example.entity.param.UserParam;
import org.example.mapper.*;
import org.example.service.UserService;
import org.example.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2022-08-26 19:30:39
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserListMapper userListMapper;

    @Autowired
    ListsMapper listsMapper;
    @Autowired
    UserSongMapper userSongMapper;
    @Autowired
    SongMapper songMapper;
    @Override
    public IPage<User> selectByParam(UserParam userParam) {
        return userMapper.selectPage(new Page<>(PageUtil.page(), PageUtil.pageSize()), null);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectList(null);
    }

    @Override
    public IPage<Lists> selectListsByUserId(UserParam userParam) {
        List<String> ids = userListMapper.selectList(new LambdaQueryWrapper<UserList>()
                .eq(UserList::getUserId, userParam.getId())).stream().map(UserList::getListId).toList();
        return listsMapper.selectPage(new Page<>(PageUtil.page(), PageUtil.pageSize()), new LambdaQueryWrapper<Lists>()
                .in(!ids.isEmpty(), Lists::getId, ids));
    }

    @Override
    public IPage<Song> selectSongByUserId(UserParam userParam) {
        List<String> ids = userSongMapper.selectList(new LambdaQueryWrapper<UserSong>()
                .eq(UserSong::getUserId, userParam.getId())).stream().map(UserSong::getSongId).toList();
        return songMapper.selectPage(new Page<>(PageUtil.page(), PageUtil.pageSize()), new LambdaQueryWrapper<Song>()
                .in(!ids.isEmpty(), Song::getId, ids));
    }
}


