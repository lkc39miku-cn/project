package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.Album;
import org.example.service.AlbumService;
import org.example.mapper.AlbumMapper;
import org.springframework.stereotype.Service;

/**
* @author adm
* @description 针对表【album(专辑)】的数据库操作Service实现
* @createDate 2022-08-24 19:02:25
*/
@Service
public class AlbumServiceImpl extends ServiceImpl<AlbumMapper, Album>
    implements AlbumService{

}




