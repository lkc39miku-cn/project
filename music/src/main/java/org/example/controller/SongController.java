package org.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.example.entity.Song;
import org.example.entity.convert.SongConvert;
import org.example.entity.param.SongParam;
import org.example.entity.vo.DeptVo;
import org.example.entity.vo.SongVo;
import org.example.model.PageR;
import org.example.model.R;
import org.example.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @ApiOperation(value = "歌曲信息查询",notes = "歌曲信息查询")
    @GetMapping("/selectAll")
    public PageR<List<SongVo>> selectAll(SongParam songParam) {
        IPage<Song> songIPage = songService.selectByParam(songParam);
        return new PageR<List<SongVo>>().ok(songConvert.convert(songIPage.getRecords()))
                .setCount(songIPage.getTotal());

    }

    @ApiOperation(value = "通过主键查询歌曲详情", notes = "通过主键查询歌曲详情")
    @GetMapping("/findSongById/{id}")
    public  R<Song> findSong(@PathVariable(value = "id") String id){
        return new R<Song>().ok(songService.findSong(id)) ;
    }

}
