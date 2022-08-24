package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.Fans;
import org.example.service.FansService;
import org.example.mapper.FansMapper;
import org.springframework.stereotype.Service;

/**
* @author adm
* @description 针对表【fans(粉丝关注表)】的数据库操作Service实现
* @createDate 2022-08-24 19:03:48
*/
@Service
public class FansServiceImpl extends ServiceImpl<FansMapper, Fans>
    implements FansService{

}




