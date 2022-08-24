package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.StaffRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRoleMapper extends BaseMapper<StaffRole> {
    int assignBatch(@Param(value = "id") String id, @Param(value = "staffIdList") List<String> staffIdList);
}
