package org.example.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.Staff;
import org.example.entity.StoreHouseOut;

import java.io.Serial;

@ApiModel(value="库存出库Vo")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(value = "handler")
public class StoreHouseOutVo extends StoreHouseOut {
    @Serial
    private static final long serialVersionUID = 4830715725873182713L;

    @ApiModelProperty(value="库存")
    private StoreHouseVo storeHouseVo;

    @ApiModelProperty(value="提交人")
    private Staff publishStaff;

    @ApiModelProperty(value = "审核人")
    private Staff targetStaff;
}
