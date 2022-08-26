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
public class StoreHouse extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -5611563626807365662L;

    @ApiModelProperty(value = "商品id")
    protected String commodityId;

    @ApiModelProperty(value = "商品库存")
    protected Integer stock;

    @ApiModelProperty(value = "商品库存预警值")
    protected Integer lowStock;

    @ApiModelProperty(value = "商品库存描述")
    protected String storeHouseInfo;

    @ApiModelProperty(value = "删除状态 0 未删除 1 已删除")
    protected Integer deleteStatus;
}
