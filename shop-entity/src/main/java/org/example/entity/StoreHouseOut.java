package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;
import java.io.Serial;

@ApiModel(value="仓库出货记录表")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class StoreHouseOut extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 2847799636159860685L;
    @ApiModelProperty(value = "仓库id")
    protected String storeHouseId;

    @ApiModelProperty(value = "预计出货数量")
    protected Integer outNumber;

    @ApiModelProperty(value = "实际出货数量")
    protected Integer realOutNumber;

    @ApiModelProperty(value = "备注")
    protected String storeHouseOutInfo;

    @ApiModelProperty(value = "出库状态 0 未出库 1 已出库")
    protected Integer storeHouseOutStatus;

    @ApiModelProperty(value = "删除状态 0 未删除 1 已删除")
    protected Integer deleteStatus;

    @ApiModelProperty(value = "审核人id")
    protected String staffId;

    @ApiModelProperty(value = "提交人id ")
    protected String targetId;
}
