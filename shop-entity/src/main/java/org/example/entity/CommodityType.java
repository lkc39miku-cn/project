package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;

import java.io.Serial;

@ApiModel(value="品牌类型")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class CommodityType extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 8972663260988954031L;

    @ApiModelProperty(value = "品牌类型名称")
    private String name;

    @ApiModelProperty(value = "显示状态")
    private String publishStatus;

    @ApiModelProperty(value = "排序")
    private String Sort;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "上级类型")
    private String parentId;

    @ApiModelProperty(value = "判断是否为类型")
    private String isType;

}
