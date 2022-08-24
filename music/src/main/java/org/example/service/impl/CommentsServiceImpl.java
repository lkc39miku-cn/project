package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.Comments;
import org.example.service.CommentsService;
import org.example.mapper.CommentsMapper;
import org.springframework.stereotype.Service;

/**
* @author adm
* @description 针对表【comments(评论表)】的数据库操作Service实现
* @createDate 2022-08-24 19:03:02
*/
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments>
    implements CommentsService{

}




