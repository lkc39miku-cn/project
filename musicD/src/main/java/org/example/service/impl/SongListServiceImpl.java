package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.SongList;
import org.example.service.SongListService;
import org.example.mapper.SongListMapper;
import org.springframework.stereotype.Service;

/**
* @author adm
* @description 针对表【song_list(歌单歌曲中间表)】的数据库操作Service实现
* @createDate 2022-08-24 19:12:33
*/
@Service
public class SongListServiceImpl extends ServiceImpl<SongListMapper, SongList>
    implements SongListService{

}




