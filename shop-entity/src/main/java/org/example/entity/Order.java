package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;
import java.io.Serial;

@ApiModel(value="订单")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 8972663260988954031L;

    @ApiModelProperty(value = "订单编号")
    private String orderNumber;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "支付方式id")
    private String paypalId;

    @ApiModelProperty(value = "订单费用")
    private String money;

    @ApiModelProperty(value = "订单状态id")
    private String orderTypeId;

    @ApiModelProperty(value = "显示状态")
    private String publishStatus;

    @ApiModelProperty(value = "删除状态")
    private String deleteStatus;
}
