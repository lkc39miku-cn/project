package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Post;
import org.example.entity.StaffPost;
import org.example.entity.convert.PostConvert;
import org.example.entity.param.PostParam;
import org.example.entity.vo.PostVo;
import org.example.mapper.PostMapper;
import org.example.mapper.StaffPostMapper;
import org.example.service.PostService;
import org.example.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private StaffPostMapper staffPostMapper;
    @Autowired
    private PostConvert postConvert;

    @Override
    public PostVo selectByPrimaryKey(String id) {
        return postConvert.convert(postMapper.selectById(id));
    }

    @Override
    public IPage<Post> selectListByPage(PostParam postParam) {
        return postMapper.selectPage(new Page<>(PageUtil.page(), PageUtil.pageSize()), null);
    }

    @Override
    public List<PostVo> selectAll() {
        return postConvert.convert(postMapper.selectList(null));
    }

    @Override
    public boolean checkPostName(String name) {
        return Objects.nonNull(postMapper.selectOne(new LambdaQueryWrapper<Post>().eq(Post::getName, name)));
    }

    @Override
    public boolean checkPostCode(String code) {
        return Objects.nonNull(postMapper.selectOne(new LambdaQueryWrapper<Post>().eq(Post::getCode, code)));
    }

    @Override
    public boolean checkStaffPost(String id) {
        return staffPostMapper.selectList(new LambdaQueryWrapper<StaffPost>()
                .eq(StaffPost::getPostId, id)).size() > 0;
    }

    @Override
    public boolean checkPostName(String name, String id) {
        return Objects.nonNull(postMapper.selectOne(new LambdaQueryWrapper<Post>()
                .eq(Post::getName, name)
                .ne(Post::getId, id)));
    }

    @Override
    public boolean checkPostCode(String code, String id) {
        return Objects.nonNull(postMapper.selectOne(new LambdaQueryWrapper<Post>()
                .eq(Post::getCode, code)
                .ne(Post::getId, id)));
    }

    @Override
    public int insert(Post post) {
        return postMapper.insert(post);
    }

    @Override
    public int delete(String id) {
        return postMapper.deleteById(id);
    }

    @Override
    public int update(Post post) {
        return postMapper.updateById(post);
    }
}
