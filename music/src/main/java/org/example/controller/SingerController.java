package org.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.example.entity.Singer;
import org.example.entity.Song;
import org.example.entity.convert.SingerConvert;
import org.example.entity.param.SingerParam;
import org.example.entity.param.SongParam;
import org.example.entity.vo.SingerVo;
import org.example.entity.vo.SongVo;
import org.example.mapper.SingerMapper;
import org.example.model.PageR;
import org.example.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/singer")
@Api(tags = "歌曲歌单管理")
public class SingerController {
@Autowired
SingerService singerService;
@Autowired
    SingerConvert singerConvert;

    @ApiOperation(value = "歌手信息查询",notes = "歌手信息查询")
    @GetMapping("selectAll")
    public PageR<List<SingerVo>> selectAll(SingerParam singerParam) {

        IPage<Singer> singerIPage = singerService.selectByParam(singerParam);
        return new PageR<List<SingerVo>>().ok(singerConvert.convert(singerIPage.getRecords()))
                .setCount(singerIPage.getTotal());

    }
}
