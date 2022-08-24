package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptMapper extends BaseMapper<Dept> {
    List<String> roleTree(@Param(value = "id") String id, @Param(value = "deptCheckStrictly") boolean deptCheckStrictly);
}
