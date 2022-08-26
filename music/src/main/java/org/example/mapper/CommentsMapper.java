package org.example.mapper;

import org.example.entity.Comments;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author adm
* @description 针对表【comments(评论表)】的数据库操作Mapper
* @createDate 2022-08-24 19:03:02
* @Entity org.example.entity.Comments
*/@Repository

public interface CommentsMapper extends BaseMapper<Comments> {

}




