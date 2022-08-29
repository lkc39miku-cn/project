package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.entity.Album;
import org.example.entity.Dept;
import org.example.entity.Song;
import org.example.entity.convert.SongConvert;
import org.example.entity.param.SongParam;
import org.example.entity.vo.SongVo;
import org.example.service.SongService;
import org.example.mapper.SongMapper;
import org.example.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
* @author adm
* @description 针对表【song(歌曲表)】的数据库操作Service实现
* @createDate 2022-08-24 19:12:24
*/
@Service
public class SongServiceImpl implements SongService{
@Autowired
private SongMapper songMapper;
@Autowired
private SongConvert songConvert;
    @Override
    public IPage<Song> selectByParam(SongParam songParam) {

            return songMapper.selectPage(new Page<>(PageUtil.page(), PageUtil.pageSize()), null);
    }

    @Override
    public List<SongVo> selectAll() {
        return songConvert.convert(songMapper.selectList(null));
}

    @Override
    public SongVo findSong(String id) {
        return songConvert.convert(songMapper.selectById(id));
    }
}




