package org.example.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;
import java.io.Serial;

@ApiModel(value="秒杀订单表")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class seckillOrderInfo extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 8972663260988954031L;

    @ApiModelProperty(value = "商品的id")
    private String CommodityId;

    @ApiModelProperty(value = "支付金额")
    private String maney;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "支付时间")
    private String timeOfPayment;

    @ApiModelProperty(value = "收货人地址")
    private String consigneeAddress;

    @ApiModelProperty(value = "收货人电话")
    private String Phone;

    @ApiModelProperty(value = "收货人")
    private String ren;

    @ApiModelProperty(value = "交易流水号")
    private String shui;
}
