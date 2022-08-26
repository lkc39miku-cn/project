package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;
import java.io.Serial;

@ApiModel(value="订单明细")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class OrderInfo extends BaseEntity{
    @Serial
    private static final long serialVersionUID = 8972663260988954031L;

    @ApiModelProperty(value = "用户id")
    private String orderId;

    @ApiModelProperty(value = "商品id")
    private String commodityId;

    @ApiModelProperty(value = "商品单价")
    private String price;

    @ApiModelProperty(value = "商品数量")
    private String number;

    @ApiModelProperty(value = "商品总量")
    private String allPrice;

    @ApiModelProperty(value = "用户的地址id")
    private String userAddressId;

    @ApiModelProperty(value = "订单状态id")
    private String orderTypeId;

    @ApiModelProperty(value = "显示状态")
    private String publishStatus;

    @ApiModelProperty(value = "删除状态")
    private String deleteStatus;
}
