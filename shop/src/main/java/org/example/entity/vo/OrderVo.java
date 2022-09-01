package org.example.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.Order;

import java.io.Serial;
import java.util.List;

@ApiModel(value="订单Vo")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(value = "handler")
public class OrderVo extends Order {
    @Serial
    private static final long serialVersionUID = -7833865581929248086L;

    @ApiModelProperty(value = "订单详情")
    private List<OrderInfoVo> orderInfoVoList;
}
