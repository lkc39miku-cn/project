package org.example.entity.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value="商品品牌参数")
public class CommodityBrandParam {
    @ApiModelProperty(value = "展示状态 1:展示 0:不展示")
    private Integer publishStatus;
}
