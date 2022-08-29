package org.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.entity.Lists;
import org.example.entity.Song;
import org.example.entity.User;
import org.example.entity.param.SongParam;
import org.example.entity.param.UserParam;
import org.example.entity.vo.ListsVo;
import org.example.entity.vo.SongVo;

import java.util.List;

/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2022-08-26 19:30:39
 */
public interface UserService  {
    IPage<User> selectByParam(UserParam userParam);
    List<User> selectAll();
    IPage<Lists> selectListsByUserId(UserParam userParam);
    IPage<Song> selectSongByUserId(UserParam userParam);
}

