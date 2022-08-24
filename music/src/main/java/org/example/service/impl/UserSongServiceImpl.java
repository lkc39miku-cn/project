package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.UserSong;
import org.example.service.UserSongService;
import org.example.mapper.UserSongMapper;
import org.springframework.stereotype.Service;

/**
* @author adm
* @description 针对表【user_song(用户收藏歌曲表)】的数据库操作Service实现
* @createDate 2022-08-24 19:12:49
*/
@Service
public class UserSongServiceImpl extends ServiceImpl<UserSongMapper, UserSong>
    implements UserSongService{

}




