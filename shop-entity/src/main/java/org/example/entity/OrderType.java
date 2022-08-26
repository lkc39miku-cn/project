package org.example.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;
import java.io.Serial;

@ApiModel(value="订单的状态")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)

public class OrderType extends BaseEntity{
    @Serial
    private static final long serialVersionUID = 8972663260988954031L;

    @ApiModelProperty(value = "订单状态名称")
    private String name;
}
