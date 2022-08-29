package org.example.entity.convert;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.entity.Album;
import org.example.entity.Singer;
import org.example.entity.Song;
import org.example.entity.vo.SongVo;
import org.example.mapper.AlbumMapper;
import org.example.mapper.SingerMapper;
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
public abstract class SongConvert implements Convert<Song, SongVo> {
    @Autowired
    private SongMapper songMapper;
    @Autowired
    private AlbumMapper albumMapper;
    @Autowired
    private SingerMapper singerMapper;

    @Override
    public abstract SongVo convert(Song song);
    @Override
    public abstract List<SongVo> convert(List<Song> songList);

    @AfterMapping
    public void convert(Song song,@MappingTarget SongVo songVo) {
        songVo.setAlbum(albumMapper.selectOne(new LambdaQueryWrapper<Album>()
                .eq(Album::getId, song.getAlbumId())))
                .setSinger(singerMapper.selectOne(new LambdaQueryWrapper<Singer>()
                        .eq(Singer::getId,song.getSingerId())));
    }
    @AfterMapping
    public void convert(List<Song> songList,@MappingTarget List<SongVo> songVoList) {
        songVoList.forEach(v -> convert(null, v));
    }
}
