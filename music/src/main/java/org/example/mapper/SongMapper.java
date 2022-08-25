package org.example.mapper;

import org.example.entity.Song;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author adm
* @description 针对表【song(歌曲表)】的数据库操作Mapper
* @createDate 2022-08-24 19:12:24
* @Entity org.example.entity.Song
*/@Repository

public interface SongMapper extends BaseMapper<Song> {

}




