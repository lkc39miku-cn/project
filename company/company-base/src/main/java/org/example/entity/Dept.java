package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;

import java.io.Serial;

@ApiModel(value="部门")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Dept extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 8972663260988954031L;

    @ApiModelProperty(value="父部门")
    protected String parentId;

    @ApiModelProperty(value="祖级列表")
    protected String ancestors;

    @ApiModelProperty(value="部门名称")
    protected String name;

    @ApiModelProperty(value="显示顺序")
    protected Integer deptOrder;

    @ApiModelProperty(value="外键 负责人")
    protected String leaderId;

    @ApiModelProperty(value="联系电话")
    protected String phone;

    @ApiModelProperty(value="邮箱")
    protected String email;

    @ApiModelProperty(value="部门状态 0正常 1停用")
    protected Integer status;

    @ApiModelProperty(value="删除标志 0代表存在 1代表删除")
    protected Integer deleteStatus;

    @ApiModelProperty(value="创建者Id")
    protected String createStaffId;

    @ApiModelProperty(value="备注")
    protected String remark;
}