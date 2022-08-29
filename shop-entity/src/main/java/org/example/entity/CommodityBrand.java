package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;

import java.io.Serial;

@ApiModel(value="商品品牌")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class CommodityBrand extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -2012782948290074235L;
    @ApiModelProperty(value = "商品品牌名称")
    protected String name;

    @ApiModelProperty(value = "商品品牌首字母")
    protected String firstLetter;

    @ApiModelProperty(value = "显示状态 0 不显示 1 显示")
    protected Integer publishStatus;

    @ApiModelProperty(value = "品牌logo")
    protected String logo;

    @ApiModelProperty(value = "专区大图")
    protected String bigLogo;

    @ApiModelProperty(value = "品牌故事")
    protected String description;

}
