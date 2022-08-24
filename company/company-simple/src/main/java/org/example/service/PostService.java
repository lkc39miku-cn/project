package org.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.entity.Post;
import org.example.entity.param.PostParam;
import org.example.entity.vo.PostVo;

import java.util.List;

public interface PostService {
    PostVo selectByPrimaryKey(String id);

    IPage<Post> selectListByPage(PostParam postParam);

    List<PostVo> selectAll();

    boolean checkPostName(String name);

    boolean checkPostCode(String code);

    boolean checkStaffPost(String id);

    boolean checkPostName(String name, String id);

    boolean checkPostCode(String code, String id);

    int insert(Post post);

    int delete(String id);



    int update(Post post);

}
