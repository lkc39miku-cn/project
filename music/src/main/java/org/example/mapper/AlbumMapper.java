package org.example.mapper;

import org.example.entity.Album;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author adm
* @description 针对表【album(专辑)】的数据库操作Mapper
* @createDate 2022-08-24 19:02:25
* @Entity org.example.entity.Album
*/
@Repository
public interface AlbumMapper extends BaseMapper<Album> {

}




