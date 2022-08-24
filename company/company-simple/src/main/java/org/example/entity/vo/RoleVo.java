package org.example.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.Role;
import org.example.entity.Staff;

import java.io.Serial;

@ApiModel(value="角色Vo")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(value = "handler")
public final class RoleVo extends Role {
    @Serial
    private static final long serialVersionUID = 3626895904378816053L;

    @ApiModelProperty(value = "创建者")
    private Staff createStaff;
}
