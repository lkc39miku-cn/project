package org.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.entity.Lists;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.entity.Song;
import org.example.entity.param.ListsParam;
import org.example.entity.vo.ListsVo;

import java.util.List;

/**
* @author adm
* @description 针对表【lists(歌单)】的数据库操作Service
* @createDate 2022-08-24 19:04:17
*/
public interface ListsService {
    IPage<Lists> selectByParam(ListsParam listsParam);
    List<ListsVo> selectAll();
    IPage<Song> selectSongList(ListsParam listsParam);
}
