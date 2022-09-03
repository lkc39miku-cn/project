package org.example.entity.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@ApiModel(value="角色Param")
@Data
@Accessors(chain = true)
public final class RoleParam {
    private String id;

    @ApiModelProperty(value = "角色状态 0正常 1停用")
    private Integer status;

    @ApiModelProperty(value = "删除标志 0代表存在 1代表删除")
    private Integer deleteStatus;

    @ApiModelProperty(value = "可见数据范围 分配部门")
    private List<String> deptIdList;

    private List<String> menuIdList;

    private List<String> staffIdList;
}
