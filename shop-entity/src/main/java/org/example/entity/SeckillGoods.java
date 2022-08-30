package org.example.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;
import org.hibernate.validator.constraints.Length;

/**
* 秒杀商品表
* @TableName seckill_goods
*/@ApiModel(value="订单明细")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class SeckillGoods extends BaseEntity {
    @Serial
    private static final long serialVersionUID = -5532102041334625891L;
    /**
    * 商品id
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("商品id")
    @Length(max= 255,message="编码长度不能超过255")
    private String goodsId;
    /**
    * 秒杀价
    */
    @ApiModelProperty("秒杀价")
    private BigDecimal seckillPrice;
    /**
    * 秒杀数量
    */
    @ApiModelProperty("秒杀数量")
    private Date seckillCount;
    /**
    * 秒杀开始时间
    */
    @ApiModelProperty("秒杀开始时间")
    private Date startDate;
    /**
    * 秒杀结束时间
    */
    @ApiModelProperty("秒杀结束时间")
    private Date endDate;
    /**
    * 秒杀状态
    */
    @ApiModelProperty("秒杀状态")
    private Integer seckillStatus;



}
