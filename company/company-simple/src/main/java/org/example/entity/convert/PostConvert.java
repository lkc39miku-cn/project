package org.example.entity.convert;

import org.example.entity.Post;
import org.example.entity.vo.PostVo;
import org.example.util.Convert;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class PostConvert implements Convert<Post, PostVo> {
    @Override
    public abstract PostVo convert(Post post);
    @Override
    public abstract List<PostVo> convert(List<Post> postList);

    @AfterMapping
    public void convert(Post post, PostVo postVo) {
    }

    @AfterMapping
    public void convert(List<Post> postList, List<PostVo> postVoList) {
    }
}
