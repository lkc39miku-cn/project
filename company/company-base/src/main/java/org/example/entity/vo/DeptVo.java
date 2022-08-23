package org.example.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.Dept;

import java.io.Serial;
import java.util.List;

@ApiModel(value="部门Vo")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(value = "handler")
public final class DeptVo extends Dept {
    @Serial
    private static final long serialVersionUID = -5302349466820596459L;

    @ApiModelProperty(value="创建人")
    private StaffVo createStaff;

    @ApiModelProperty(value = "领导人")
    private StaffVo leaderStaff;

    @ApiModelProperty(value = "子部门")
    private List<DeptVo> children;

    @ApiModelProperty(value = "选中状态")
    private boolean checked;
}
