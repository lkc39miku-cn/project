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

@ApiModel(value="商品")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Commodity extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -4661847076018103061L;
    @ApiModelProperty(value = "商品标题")
    protected String title;

    @ApiModelProperty(value = "商品副标题")
    protected String subTitle;

    @ApiModelProperty(value = "商品价格")
    protected BigDecimal price;

    @ApiModelProperty(value = "商品数量")
    protected Integer commodityNumber;

    @ApiModelProperty(value = "商品描述")
    protected String description;

    @ApiModelProperty(value = "商品图片")
    protected String photo;

    @ApiModelProperty(value = "商品详情图")
    protected String fullPhoto;

    @ApiModelProperty(value = "商品品牌id")
    protected String commodityBrandId;

    @ApiModelProperty(value = "品牌类型id")
    protected String commodityTypeId;

    @ApiModelProperty(value = "商品预售截止时间")
    protected LocalDateTime previewEndTime;

    @ApiModelProperty(value = "预售说明")
    protected String previewInfo;

    @ApiModelProperty(value = "发售时间")
    protected LocalDateTime saleStartTime;

    @ApiModelProperty(value = "商品秒杀价格")
    protected BigDecimal promotionPrice;

    @ApiModelProperty(value = "商品秒杀的类型")
    protected Integer promotionType;

    @ApiModelProperty(value = "商品秒杀的开始时间")
    protected LocalDateTime promotionStartTime;

    @ApiModelProperty(value = "商品秒杀的结束时间")
    protected LocalDateTime promotionEndTime;

    @ApiModelProperty(value = "商品秒杀的数量")
    protected Integer promotionDeskillNumber;

    @ApiModelProperty(value = "商品秒杀的状态 0 开启秒杀 1 没有开启秒杀")
    protected Integer promotionDeskillStatus;

    @ApiModelProperty(value = "仓库id")
    protected String storeHouseId;

    @ApiModelProperty(value = "上架状态 0 上架 1 下架")
    protected Integer publishStatus;

    @ApiModelProperty(value = "删除状态 0 未删除 1 已删除")
    protected Integer deleteStatus;

}
