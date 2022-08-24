package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;

import java.io.Serial;


@ApiModel(value="岗位")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Post extends BaseEntity {
    @Serial
    private static final long serialVersionUID = -2967725162999037573L;

    @ApiModelProperty(value="岗位编码")
    private String code;

    @ApiModelProperty(value="岗位名称")
    private String name;

    @ApiModelProperty(value="显示顺序")
    private Integer sort;

    @ApiModelProperty(value="状态 0正常 1停用")
    private Integer status;

    @ApiModelProperty(value="创建者Id")
    private String createStaffId;

    @ApiModelProperty(value="备注")
    private String remark;
}