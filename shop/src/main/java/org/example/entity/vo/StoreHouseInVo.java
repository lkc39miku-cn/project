package org.example.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.StoreHouseIn;

import java.io.Serial;

@ApiModel(value="库存进库Vo")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(value = "handler")
public class StoreHouseInVo extends StoreHouseIn {
    @Serial
    private static final long serialVersionUID = -3302045485734827634L;

    @ApiModelProperty(value="商品")
    private CommodityVo commodityVo;
}
