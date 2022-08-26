package org.example.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;
import java.io.Serial;

@ApiModel(value="仓库的进货记录表")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class StoreHouseIn extends BaseEntity{
    @Serial
    private static final long serialVersionUID = 8972663260988954031L;

    @ApiModelProperty(value = "商品id")
    private String commodityId;

    @ApiModelProperty(value = "预计进货数量")
    private String inNumber;

    @ApiModelProperty(value = "实际进货数量")
    private String realInNumber;

    @ApiModelProperty(value = "备注")
    private String storeHouseInInfo;

    @ApiModelProperty(value = "入库状态")
    private String storeHouseInStatus;

    @ApiModelProperty(value = "删除状态")
    private String deleteStatus;
}
