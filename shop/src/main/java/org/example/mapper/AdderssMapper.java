package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.Address;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

@Repository
public interface AdderssMapper extends BaseMapper<Address> {
    List<String> roleTree(@Param(value = "id") String id, @Param(value = "addressCheckStrictly") boolean addressCheckStrictly);
}
