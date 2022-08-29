package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;

import java.io.Serial;

@ApiModel(value="商品类型")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class CommodityType extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -2075588412939772202L;
    @ApiModelProperty(value = "商品类型名称")
    protected String name;

    @ApiModelProperty(value = "显示状态 0 不显示 1 显示")
    protected Integer publishStatus;

    @ApiModelProperty(value = "排序")
    protected Integer sort;

    @ApiModelProperty(value = "图标")
    protected String icon;

    @ApiModelProperty(value = "上级类型 0表示没有上级类型")
    protected String parentId;
}
