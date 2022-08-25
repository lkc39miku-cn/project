package org.example.entity.convert;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.entity.Album;
import org.example.entity.Lists;
import org.example.entity.Song;
import org.example.entity.SongList;
import org.example.entity.vo.AlbumVo;
import org.example.entity.vo.ListsVo;
import org.example.mapper.AlbumMapper;
import org.example.mapper.ListsMapper;
import org.example.mapper.SongListMapper;
import org.example.mapper.SongMapper;
import org.example.util.Convert;
import org.example.util.PageUtil;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class ListsCovert implements Convert<Lists,ListsVo> {
    @Autowired
    private SongMapper songMapper;
    @Autowired
    private ListsMapper listsMapper;
    @Autowired
    private SongListMapper songListMapper;
    @Override
    public abstract ListsVo convert(Lists lists);
    @Override
    public abstract List<ListsVo> convert(List<Lists> listsList);

    @AfterMapping
    public void convert(Lists lists, ListsVo listsVo) {
    List<SongList> listLists=songListMapper.selectList(new LambdaQueryWrapper<SongList>().eq(SongList::getListId,lists.getId()));
        listsVo.setSongList(songMapper.selectList(new LambdaQueryWrapper<Song>()
                .in(listLists.size()>0,Song::getId,listLists)));

    }

    @AfterMapping
    public void convert(List<Lists> listsList, List<ListsVo> listsVoList) {
        listsVoList.forEach(v -> convert(null, v));
    }
}
