package org.example.entity.convert;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.entity.Singer;
import org.example.entity.Song;
import org.example.entity.User;
import org.example.entity.vo.SingerVo;
import org.example.entity.vo.SongVo;
import org.example.mapper.SingerMapper;
import org.example.mapper.UserMapper;
import org.example.util.Convert;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper(componentModel = "spring")
@Component
public abstract class SingerConvert implements Convert<Singer, SingerVo> {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SingerMapper singerMapper;

    @Override
    public abstract SingerVo convert(Singer singer);

    @Override
    public abstract List<SingerVo> convert(List<Singer> singerList);

    @AfterMapping
    public void convert(Singer singer, @MappingTarget SingerVo singerVo) {
        singerVo.setUser(userMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getId, singer.getUserId())));

    }

    @AfterMapping
    public void convert(List<Singer> singerList, List<SingerVo> singerVoList) {
        singerVoList.forEach(v -> convert(null, v));
    }

}
