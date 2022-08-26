package org.example.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;
import java.io.Serial;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value="秒杀订单表")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class DeskillOrderInfo extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 7874770723164458441L;
    @ApiModelProperty(value = "商品id")
    private String CommodityId;

    @ApiModelProperty(value = "支付金额")
    private BigDecimal money;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "支付时间")
    private LocalDateTime timeOfPayment;

    @ApiModelProperty(value = "收货人地址id")
    private String consigneeAddressId;

    @ApiModelProperty(value = "收货人电话")
    private String phone;

    @ApiModelProperty(value = "收货人")
    private String name;

    @ApiModelProperty(value = "交易流水号")
    private String orderNumber;
}
