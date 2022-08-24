package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.Song;
import org.example.service.SongService;
import org.example.mapper.SongMapper;
import org.springframework.stereotype.Service;

/**
* @author adm
* @description 针对表【song(歌曲表)】的数据库操作Service实现
* @createDate 2022-08-24 19:12:24
*/
@Service
public class SongServiceImpl extends ServiceImpl<SongMapper, Song>
    implements SongService{

}




