package org.example.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.Commodity;
import org.example.entity.CommodityBrand;
import org.example.entity.CommodityType;

import java.io.Serial;

@ApiModel(value="商品Vo")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(value = "handler")
public class CommodityVo extends Commodity {
    @Serial
    private static final long serialVersionUID = -81237467837977324L;

    @ApiModelProperty(value="商品类型")
    private CommodityType commodityType;
    @ApiModelProperty(value="商品品牌")
    private CommodityBrand commodityBrand;
}
