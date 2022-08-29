package org.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.entity.Singer;
import org.example.entity.convert.SingerConvert;
import org.example.entity.param.SingerParam;
import org.example.entity.param.SongParam;
import org.example.entity.vo.SingerVo;
import org.example.mapper.SingerMapper;
import org.example.service.SingerService;
import org.example.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SingerServiceImpl implements SingerService {
    @Autowired
    SingerMapper singerMapper;
    @Autowired
    SingerConvert singerConvert;
    @Override
    public IPage<Singer> selectByParam(SingerParam singerParam) {
        return singerMapper.selectPage(new Page<>(PageUtil.page(), PageUtil.pageSize()), null);
    }

    @Override
    public List<SingerVo> selectAll() {
        return singerConvert.convert(singerMapper.selectList(null));
    }
}
