package org.example.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.StoreHouse;

import java.io.Serial;

@ApiModel(value="库存Vo")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(value = "handler")
public class StoreHouseVo extends StoreHouse {
    @Serial
    private static final long serialVersionUID = -231234917914087571L;

    @ApiModelProperty(value="商品")
    private CommodityVo commodityVo;
}
