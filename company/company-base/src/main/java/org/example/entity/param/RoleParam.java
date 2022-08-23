package org.example.entity.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel(value="角色Param")
@Data
public final class RoleParam {
    @ApiModelProperty(value = "可见数据范围 分配部门")
    private List<String> deptIdList;
}
