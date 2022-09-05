package org.example.entity.param;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.Order;
import org.example.entity.OrderInfo;

import java.io.Serial;
import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="订单参数")
public class OrderParam extends Order {
    @Serial
    private static final long serialVersionUID = 8653588710034512913L;
    @TableField(exist = false)
    private List<OrderInfo> orderInfoList;

    @TableField(exist = false)
    private String type;

}
