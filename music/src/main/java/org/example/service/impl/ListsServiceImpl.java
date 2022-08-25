package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.Lists;
import org.example.entity.Song;
import org.example.entity.SongList;
import org.example.entity.convert.ListsCovert;
import org.example.entity.param.ListsParam;
import org.example.entity.vo.ListsVo;
import org.example.mapper.SongListMapper;
import org.example.mapper.SongMapper;
import org.example.service.ListsService;
import org.example.mapper.ListsMapper;
import org.example.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author adm
* @description 针对表【lists(歌单)】的数据库操作Service实现
* @createDate 2022-08-24 19:04:17
*/
@Service
public class ListsServiceImpl
    implements ListsService {
    @Autowired
    private ListsMapper listsMapper;
    @Autowired
    private SongListMapper songListMapper;
    @Autowired
    private SongMapper songMapper;

    @Autowired
    private ListsCovert listsCovert;

    @Override
    public IPage<Lists> selectByParam(ListsParam listsParam) {
        return null;
    }

    @Override
    public List<Lists> selectAll() {
        return null;
    }

    @Override
    public IPage<Song> selectSongList(ListsParam listsParam) {
        List<String> ids = songListMapper.selectList(new LambdaQueryWrapper<SongList>()
                .eq(SongList::getListId, listsParam.getId())).stream().map(SongList::getSongId).toList();
        return songMapper.selectPage(new Page<>(PageUtil.page(), PageUtil.pageSize()), new LambdaQueryWrapper<Song>()
                .in(!ids.isEmpty(), Song::getId, ids));
    }
}




