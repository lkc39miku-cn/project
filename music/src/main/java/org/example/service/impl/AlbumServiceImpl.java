package org.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.entity.Album;
import org.example.entity.convert.AlbumCovert;
import org.example.entity.param.AlbumParam;
import org.example.entity.vo.AlbumVo;
import org.example.mapper.AlbumMapper;
import org.example.service.AlbumService;
import org.example.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    AlbumMapper albumMapper;
    @Autowired
    AlbumCovert albumCovert;
    @Override
    public IPage<Album> selectByParam(AlbumParam albumParam) {
        return albumMapper.selectPage(new Page<>(PageUtil.page(), PageUtil.pageSize()), null);
    }

    @Override
    public List<AlbumVo> selectAll() {
        return albumCovert.convert(albumMapper.selectList(null));
    }
}
