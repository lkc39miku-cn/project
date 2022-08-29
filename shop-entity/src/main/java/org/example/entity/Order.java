package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;
import java.io.Serial;
import java.math.BigDecimal;

@ApiModel(value="订单")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 3787128638798915004L;
    @ApiModelProperty(value = "订单编号")
    protected String orderNumber;

    @ApiModelProperty(value = "用户id")
    protected String userId;

    @ApiModelProperty(value = "支付方式")
    protected String paypalName;

    @ApiModelProperty(value = "订单费用")
    protected BigDecimal money;

    @ApiModelProperty(value = "订单状态")
    protected Integer orderType;

    @ApiModelProperty(value = "显示状态 0 不显示 1 显示")
    protected Integer publishStatus;

    @ApiModelProperty(value = "删除状态 0 未删除 1 已删除")
    protected Integer deleteStatus;
}
