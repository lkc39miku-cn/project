package org.example.entity.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value="库存出库参数")
public class StoreHouseOutParam {
}
