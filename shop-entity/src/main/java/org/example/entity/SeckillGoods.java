package org.example.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 秒杀商品表
* @TableName seckill_goods
*/
public class SeckillGoods implements Serializable {

    /**
    * 秒杀商品id
    */
    @NotBlank(message="[秒杀商品id]不能为空")
    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("秒杀商品id")
    @Length(max= 32,message="编码长度不能超过32")
    private String id;
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
    * 库存数量
    */
    @ApiModelProperty("库存数量")
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
