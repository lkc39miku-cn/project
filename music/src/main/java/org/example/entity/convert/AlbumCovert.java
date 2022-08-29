package org.example.entity.convert;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.entity.Album;
import org.example.entity.Song;
import org.example.entity.vo.AlbumVo;
import org.example.mapper.AlbumMapper;
import org.example.mapper.SongMapper;
import org.example.util.Convert;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class AlbumCovert implements Convert<Album, AlbumVo> {
    @Autowired
    private SongMapper songMapper;
    @Autowired
    private AlbumMapper albumMapper;
    @Override
    public abstract AlbumVo convert(Album album);
    @Override
    public abstract List<AlbumVo> convert(List<Album> albumList);

    @AfterMapping
    public void convert(Album album,@MappingTarget AlbumVo albumVo) {
        albumVo.setSongList(songMapper.selectList(new LambdaQueryWrapper<Song>()
                .eq(Song::getAlbumId, albumVo.getId())));

    }

    @AfterMapping
    public void convert(List<Album> albumList, @MappingTarget List<AlbumVo> albumVoList) {
        albumVoList.forEach(v -> convert(null, v));
    }
}
