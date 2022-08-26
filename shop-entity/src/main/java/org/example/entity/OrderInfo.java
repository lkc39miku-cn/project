package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;
import java.io.Serial;
import java.math.BigDecimal;

@ApiModel(value="订单明细")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class OrderInfo extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -5530202041334625891L;
    @ApiModelProperty(value = "用户id")
    protected String orderId;

    @ApiModelProperty(value = "商品id")
    protected String commodityId;

    @ApiModelProperty(value = "商品单价")
    protected BigDecimal price;

    @ApiModelProperty(value = "商品数量")
    protected Integer number;

    @ApiModelProperty(value = "商品总价")
    protected BigDecimal allPrice;

    @ApiModelProperty(value = "用户地址id")
    protected String userAddressId;

    @ApiModelProperty(value = "订单状态")
    protected Integer orderType;

    @ApiModelProperty(value = "显示状态 0 不显示 1 显示")
    protected Integer publishStatus;

    @ApiModelProperty(value = "删除状态 0 未删除 1 已删除")
    protected Integer deleteStatus;
}
