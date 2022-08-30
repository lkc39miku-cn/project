package org.example.entity.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value="商品参数")
public class CommodityParam {
    @ApiModelProperty(value = "商品上架 1上架 0下架")
    private Integer publishStatus;

    @ApiModelProperty(value = "商品删除 1删除 0未删除")
    private Integer deleteStatus;
}
