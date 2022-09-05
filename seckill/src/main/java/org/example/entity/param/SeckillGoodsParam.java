package org.example.entity.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@ApiModel(value="秒杀商品参数")
public class SeckillGoodsParam {
    private  String goodsId;
    private  Double seckillPrice;
    private  Integer seckillCount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
