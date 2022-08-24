package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.example.entity.Staff;
import org.example.entity.param.StaffParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffMapper extends BaseMapper<Staff> {
    IPage<Staff> selectAssigned(Page<Object> objectPage, @Param(value = "staffParam") StaffParam staffParam);

    IPage<Staff> selectUnAssigned(Page<Object> objectPage, @Param(value = "staffParam") StaffParam staffParam);
}
