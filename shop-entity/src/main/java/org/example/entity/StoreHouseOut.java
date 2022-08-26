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
public class StoreHouseOut extends BaseEntity{
    @Serial
    private static final long serialVersionUID = 8972663260988954031L;

    @ApiModelProperty(value = "仓库id")
    private String storeHouesId;

    @ApiModelProperty(value = "预计出货数量")
    private String outNumber;

    @ApiModelProperty(value = "实际出货数量")
    private String realOutNumber;

    @ApiModelProperty(value = "备注")
    private String storeHouseOutInfo;

    @ApiModelProperty(value = "出库状态")
    private String storeHouseOutStatus;

    @ApiModelProperty(value = "删除状态")
    private String deleteStatus;

    @ApiModelProperty(value = "审核人")
    private String staddId;

    @ApiModelProperty(value = "提交人")
    private String targetId;
}
