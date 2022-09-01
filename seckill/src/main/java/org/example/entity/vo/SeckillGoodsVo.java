package org.example.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.Commodity;
import org.example.entity.SeckillGoods;

import java.io.Serial;

@ApiModel(value="秒杀商品Vo")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(value = "handler")
public class SeckillGoodsVo extends SeckillGoods {
    @Serial
    private static final long serialVersionUID = 7734845018217348418L;
    private Commodity commodity;
}
