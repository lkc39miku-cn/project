package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

@ApiModel(value = "角色部门关联")
@Data
@Accessors(chain = true)
public class RoleDept implements Serializable {
    @Serial
    private static final long serialVersionUID = -1304099449557101317L;

    @ApiModelProperty(value="外键 角色Id")
    private String roleId;

    @ApiModelProperty(value="外键 部门Id")
    private String deptId;
}
