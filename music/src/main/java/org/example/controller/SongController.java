package org.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.example.entity.Song;
import org.example.entity.convert.SongConvert;
import org.example.entity.param.SongParam;
import org.example.entity.vo.SongVo;
import org.example.model.PageR;
import org.example.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/song")
@Api(tags = "歌曲管理")
public class SongController {
    @Autowired
    SongService songService;
    @Autowired
    SongConvert songConvert;

    @ApiModelProperty("歌曲信息查询")
    @GetMapping("selectAll")
    public PageR<List<SongVo>> selectAll(SongParam songParam) {

        IPage<Song> songIPage = songService.selectByParam(songParam);
        return new PageR<List<SongVo>>().ok(songConvert.convert(songIPage.getRecords()))
                .setCount(songIPage.getTotal());

    }


}
