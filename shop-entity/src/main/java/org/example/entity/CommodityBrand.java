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
    private static final long serialVersionUID = 8972663260988954031L;

    @ApiModelProperty(value = "商品品牌名称")
    private String name;

    @ApiModelProperty(value = "商品品牌首字母")
    private String firstLetter;

    @ApiModelProperty(value = "显示状态")
    private String publishStatus;

    @ApiModelProperty(value = "品牌logo")
    private String logo;

    @ApiModelProperty(value = "专区大图")
    private String bigLogo;

    @ApiModelProperty(value = "品牌故事")
    private String description;

}
