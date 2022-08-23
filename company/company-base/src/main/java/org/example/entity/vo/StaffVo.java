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
import java.util.List;

@ApiModel(value="员工Vo")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(value = "handler")
public final class StaffVo extends Staff {
    @Serial
    private static final long serialVersionUID = -3965432170248840502L;

    @ApiModelProperty(value="创建人")
    private StaffVo createStaff;

    @ApiModelProperty(value = "部门")
    private DeptVo dept;

    @ApiModelProperty(value = "角色列表")
    private List<Role> roleList;
}
