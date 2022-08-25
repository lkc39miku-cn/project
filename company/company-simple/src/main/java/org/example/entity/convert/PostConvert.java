package org.example.entity.convert;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.entity.Post;
import org.example.entity.Staff;
import org.example.entity.vo.PostVo;
import org.example.mapper.StaffMapper;
import org.example.util.Convert;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class PostConvert implements Convert<Post, PostVo> {
    @Autowired
    private StaffMapper staffMapper;
    @Override
    public abstract PostVo convert(Post post);
    @Override
    public abstract List<PostVo> convert(List<Post> postList);

    @AfterMapping
    public void convert(Post post, @MappingTarget PostVo postVo) {
        postVo.setCreateStaff(staffMapper.selectOne(new LambdaQueryWrapper<Staff>()
                .eq(Staff::getId, postVo.getCreateStaffId())));
    }

    @AfterMapping
    public void convert(List<Post> postList, @MappingTarget List<PostVo> postVoList) {
        postVoList.forEach(v -> convert(null, v));
    }
}
