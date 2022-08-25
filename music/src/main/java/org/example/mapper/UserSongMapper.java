package org.example.mapper;

import org.example.entity.UserSong;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author adm
* @description 针对表【user_song(用户收藏歌曲表)】的数据库操作Mapper
* @createDate 2022-08-24 19:12:49
* @Entity org.example.entity.UserSong
*/@Repository

public interface UserSongMapper extends BaseMapper<UserSong> {

}




