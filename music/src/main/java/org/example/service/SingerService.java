package org.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.entity.Singer;
import org.example.entity.param.SingerParam;
import org.example.entity.param.SongParam;
import org.example.entity.vo.SingerVo;

import java.util.List;

public interface SingerService {
    IPage<Singer> selectByParam(SingerParam singerParam);
    List<SingerVo> selectAll();

}
