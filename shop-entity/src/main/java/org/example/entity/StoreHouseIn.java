package org.example.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;
import java.io.Serial;

@ApiModel(value="仓库进货记录表")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class StoreHouseIn extends BaseEntity{

    @Serial
    private static final long serialVersionUID = -2212956949948704040L;
    @ApiModelProperty(value = "商品id")
    protected String commodityId;

    @ApiModelProperty(value = "预计进货数量")
    protected Integer inNumber;

    @ApiModelProperty(value = "实际进货数量")
    protected Integer realInNumber;

    @ApiModelProperty(value = "备注")
    protected String storeHouseInInfo;

    @ApiModelProperty(value = "入库状态 0 未入库 1 已入库")
    protected Integer storeHouseInStatus;

    @ApiModelProperty(value = "删除状态 0 未删除 1 已删除")
    protected Integer deleteStatus;
}
