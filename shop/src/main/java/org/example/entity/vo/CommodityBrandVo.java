package org.example.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.CommodityBrand;

import java.io.Serial;

@ApiModel(value="商品品牌Vo")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(value = "handler")
public class CommodityBrandVo extends CommodityBrand {
    @Serial
    private static final long serialVersionUID = 7117537238513553653L;

}
