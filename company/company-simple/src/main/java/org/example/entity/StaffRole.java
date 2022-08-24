package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

@ApiModel(value = "员工角色关联")
@Data
@Accessors(chain = true)
public class StaffRole implements Serializable {
    @Serial
    private static final long serialVersionUID = 5208050984284618465L;

    @ApiModelProperty(value="外键 员工Id")
    private String staffId;

    @ApiModelProperty(value="外键 角色Id")
    private String roleId;
}
