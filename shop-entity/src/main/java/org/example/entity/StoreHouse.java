package org.example.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;
import java.io.Serial;

@ApiModel(value="仓库")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class StoreHouse extends BaseEntity{
    @Serial
    private static final long serialVersionUID = 8972663260988954031L;

    @ApiModelProperty(value = "商品id")
    private String commodityId;

    @ApiModelProperty(value = "商品库存")
    private String stock;

    @ApiModelProperty(value = "商品库存预警值")
    private String lowStock;

    @ApiModelProperty(value = "商品库存描述")
    private String storeHouseInfo;

    @ApiModelProperty(value = "删除状态")
    private String deleteStatus;
}
