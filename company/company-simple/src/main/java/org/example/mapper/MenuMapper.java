package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper extends BaseMapper<Menu> {
    List<String> selectMenuPermsByStaffId(String id);

    List<String> roleTree(@Param(value = "id") String id, @Param(value = "menuCheckStrictly") boolean menuCheckStrictly);
}
