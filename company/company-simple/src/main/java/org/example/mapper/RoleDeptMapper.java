package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.RoleDept;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDeptMapper extends BaseMapper<RoleDept> {
    int insertBatch(@Param(value = "deptIdList") List<String> deptIdList, @Param(value = "id") String id);
}
