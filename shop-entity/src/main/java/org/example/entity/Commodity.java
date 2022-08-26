package org.example.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;

import java.io.Serial;

@ApiModel(value="商品")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Commodity extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 8972663260988954031L;

    @ApiModelProperty(value = "商品标题")
    protected String title;

    @ApiModelProperty(value = "商品副标题")
    protected String subTitle;

    @ApiModelProperty(value = "商品价格")
    protected String price;

    @ApiModelProperty(value = "商品数量")
    protected String commodityNumber;

    @ApiModelProperty(value = "商品描述")
    protected String description;

    @ApiModelProperty(value = "商品图片")
    protected String photo;

    @ApiModelProperty(value = "商品详情图")
    private String fullPhoto;

    @ApiModelProperty(value = "商品品牌id")
    private String commodityBrandId;

    @ApiModelProperty(value = "品牌类型id")
    private String commodityTypeId;

    @ApiModelProperty(value = "商品状态")
    private String commodityStatus;

    @ApiModelProperty(value = "商品预售截止时间")
    private String previewEndTiml;

    @ApiModelProperty(value = "预售说明")
    private String previewInfo;

    @ApiModelProperty(value = "发售时间")
    private String saleStartTime;

    @ApiModelProperty(value = "商品秒杀价格")
    private String promotionPrice;

    @ApiModelProperty(value = "商品秒杀的类型")
    private String promtionType;

    @ApiModelProperty(value = "商品秒杀的开始时间")
    private String promtionStartTime;

    @ApiModelProperty(value = "商品秒杀的结束时间")
    private String promtionEndTime;

    @ApiModelProperty(value = "商品秒杀的数量")
    private String promotionSeckillNumber;

    @ApiModelProperty(value = "商品秒杀的状态(0:开启秒杀1:没有开启秒杀)")
    private String promotionSeckillStatus;

    @ApiModelProperty(value = "仓库id")
    private String storeHouseId;

    @ApiModelProperty(value = "上架状态")
    private String publishStatus;

    @ApiModelProperty(value = "删除的状态")
    private String deleteStatus;

}
