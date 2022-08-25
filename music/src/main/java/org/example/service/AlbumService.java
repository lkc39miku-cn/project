package org.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.entity.Album;
import org.example.entity.param.AlbumParam;

import java.util.List;

/**
* @author adm
* @description 针对表【album(专辑)】的数据库操作Service
* @createDate 2022-08-24 19:02:25
*/
public interface AlbumService {

    IPage<Album> selectByParam(AlbumParam albumParam);
    List<Album> selectAll();

}
