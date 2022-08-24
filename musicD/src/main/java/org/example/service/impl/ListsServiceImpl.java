package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.Lists;
import org.example.service.ListsService;
import org.example.mapper.ListsMapper;
import org.springframework.stereotype.Service;

/**
* @author adm
* @description 针对表【lists(歌单)】的数据库操作Service实现
* @createDate 2022-08-24 19:04:17
*/
@Service
public class ListsServiceImpl extends ServiceImpl<ListsMapper, Lists>
    implements ListsService{

}




