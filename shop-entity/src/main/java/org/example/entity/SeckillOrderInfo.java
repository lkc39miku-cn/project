package org.example.entity;

import javax.validation.constraints.Size;

import java.io.Serial;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;
import org.hibernate.validator.constraints.Length;

/**
* 秒杀订单表
* @TableName mb_seckill_order_info
*/

@ApiModel(value="秒杀商品")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class SeckillOrderInfo extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -4532102041334625891L;
    /**
    * 秒杀商品表主键
    */

    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("商品的id")
    @Length(max= 255,message="编码长度不能超过255")
    private String seckillCommodityId;
    /**
    * 支付金额
    */
    @ApiModelProperty("支付金额")
    private Long maney;
    /**
    * 用户id
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("用户id")
    @Length(max= 255,message="编码长度不能超过255")
    private String userId;
    /**
    * 支付时间
    */
    @ApiModelProperty("支付时间")
    private LocalDateTime zfsj;
    /**
    * 收货人地址id
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("收货人地址id")
    @Length(max= 255,message="编码长度不能超过255")
    private String consigneeAddressId;
    /**
    * 收货人电话
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("收货人电话")
    @Length(max= 255,message="编码长度不能超过255")
    private String phone;
    /**
    * 收货人
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("收货人")
    @Length(max= 255,message="编码长度不能超过255")
    private String name;
    /**
    * 交易流水号
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("交易流水号")
    @Length(max= 255,message="编码长度不能超过255")
    private String orderNumber;
    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    private LocalDateTime createdTime;
    /**
    * 更新时间
    */
    @ApiModelProperty("更新时间")
    private LocalDateTime updatedTime;


}
