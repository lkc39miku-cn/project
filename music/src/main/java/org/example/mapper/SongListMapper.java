package org.example.mapper;

import org.example.entity.SongList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author adm
* @description 针对表【song_list(歌单歌曲中间表)】的数据库操作Mapper
* @createDate 2022-08-24 19:12:33
* @Entity org.example.entity.SongList
*/@Repository

public interface SongListMapper extends BaseMapper<SongList> {

}




