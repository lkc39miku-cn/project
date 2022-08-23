package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.entity.Post;
import org.springframework.stereotype.Repository;

@Repository
public interface PostMapper extends BaseMapper<Post> {
}
