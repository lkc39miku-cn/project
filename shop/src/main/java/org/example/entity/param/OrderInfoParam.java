package org.example.entity.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value="订单详情参数")
public class OrderInfoParam {

    @ApiModelProperty(value = "订单id")
    private String orderId;
}
