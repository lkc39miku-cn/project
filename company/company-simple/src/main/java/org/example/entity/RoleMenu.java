package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

@ApiModel(value = "角色菜单关联")
@Data
@Accessors(chain = true)
public class RoleMenu implements Serializable {
    @Serial
    private static final long serialVersionUID = 5411386418218117277L;

    @ApiModelProperty(value="外键 角色Id")
    private String roleId;

    @ApiModelProperty(value="外键 菜单Id")
    private String menuId;
}
