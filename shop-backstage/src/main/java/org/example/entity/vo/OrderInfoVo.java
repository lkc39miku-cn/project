package org.example.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.OrderInfo;

import java.io.Serial;

@ApiModel(value="订单详情Vo")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(value = "handler")
public class OrderInfoVo extends OrderInfo {
    @Serial
    private static final long serialVersionUID = 5943828985482562009L;
}
