package org.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.entity.Album;
import org.example.entity.Song;
import org.example.entity.param.SongParam;
import org.example.entity.vo.SongVo;

import java.util.List;

/**
* @author adm
* @description 针对表【song(歌曲表)】的数据库操作Service
* @createDate 2022-08-24 19:12:24
*/
public interface SongService {
    IPage<Song> selectByParam(SongParam songParam);
    List<SongVo> selectAll();

}
