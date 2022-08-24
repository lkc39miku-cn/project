package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.Singer;
import org.example.service.SingerService;
import org.example.mapper.SingerMapper;
import org.springframework.stereotype.Service;

/**
* @author adm
* @description 针对表【singer(歌手)】的数据库操作Service实现
* @createDate 2022-08-24 19:12:09
*/
@Service
public class SingerServiceImpl extends ServiceImpl<SingerMapper, Singer>
    implements SingerService{

}




