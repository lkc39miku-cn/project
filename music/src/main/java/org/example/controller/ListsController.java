package org.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.example.entity.Lists;
import org.example.entity.Song;
import org.example.entity.convert.ListsCovert;
import org.example.entity.convert.SongConvert;
import org.example.entity.param.ListsParam;
import org.example.entity.param.SongParam;
import org.example.entity.vo.ListsVo;
import org.example.entity.vo.SongVo;
import org.example.model.PageR;
import org.example.service.ListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/lists")
@Api(tags = "歌曲歌单管理")
public class ListsController {
    @Autowired
    ListsService listsService;

    @Autowired
    ListsCovert listsCovert;

    @ApiOperation(value = "歌单查询ByParam",notes = "歌单查询ByParam")
    @GetMapping("selectByParam")
    public PageR<List<Lists>> selectByParam(@RequestBody ListsParam listsParam) {
        IPage<Lists> songIPage = listsService.selectByParam(listsParam);;
        return new PageR<List<Lists>>().ok(songIPage.getRecords())
                .setCount(songIPage.getTotal());

    }
    @ApiModelProperty("查询歌单内歌曲")
    @GetMapping("selectListsSong")
    public PageR<List<Song>> selectListsSong(@RequestBody ListsParam listsParam) {
        IPage<Song> songIPage = listsService.selectSongList(listsParam);
       return new PageR<List<Song>>().ok(songIPage.getRecords())
               .setCount(songIPage.getTotal());


    }
}
