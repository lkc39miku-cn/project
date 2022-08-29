package org.example.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.CommodityType;

import java.io.Serial;
import java.util.List;

@ApiModel(value="商品类型Vo")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(value = "handler")
public class CommodityTypeVo extends CommodityType {
    @Serial
    private static final long serialVersionUID = -9100929910330762584L;

    private List<CommodityTypeVo> children;
}
