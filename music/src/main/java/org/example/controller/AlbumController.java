package org.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.example.entity.Album;
import org.example.entity.convert.AlbumCovert;
import org.example.entity.param.AlbumParam;
import org.example.entity.vo.AlbumVo;
import org.example.model.PageR;
import org.example.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/album")
@Api(tags = "歌曲专辑管理")
public class AlbumController {
    @Autowired
    AlbumService albumService;
    @Autowired
    AlbumCovert albumCovert;
    @ApiModelProperty("歌曲信息查询")
    @GetMapping("selectAll")
    public PageR<List<AlbumVo>> selectAll(AlbumParam albumParam) {

        IPage<Album> albumIPage = albumService.selectByParam(albumParam);
        return new PageR<List<AlbumVo>>().ok(albumCovert.convert(albumIPage.getRecords()))
                .setCount(albumIPage.getTotal());

    }

}
