package org.example.entity.convert;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.entity.Album;
import org.example.entity.Singer;
import org.example.entity.Slide;
import org.example.entity.User;
import org.example.entity.vo.SingerVo;
import org.example.entity.vo.SlideVo;
import org.example.mapper.AlbumMapper;
import org.example.mapper.SlideMapper;
import org.example.util.Convert;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class SLideConvert implements Convert<Slide,SlideVo> {
    @Autowired
    SlideMapper slideMapper;
    @Autowired
    AlbumMapper albumMapper;


    @Override
    public abstract SlideVo convert(Slide slide);

    @Override
    public abstract List<SlideVo> convert(List<Slide> slideList);

    @AfterMapping
    public void convert(Slide slide, @MappingTarget SlideVo slideVo) {
        slideVo.setAlbum(albumMapper.selectOne(new LambdaQueryWrapper<Album>()
                .eq(Album::getId, slide.getAlbumId())));

    }

    @AfterMapping
    public void convert(List<Slide> singerList, List<SlideVo> singerVoList) {
        singerVoList.forEach(v -> convert(null, v));
    }
}
