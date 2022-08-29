package org.example.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.CommodityComment;

import java.io.Serial;

@ApiModel(value="商品Vo")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(value = "handler")
public class CommodityCommentVo extends CommodityComment {
    @Serial
    private static final long serialVersionUID = -2164474002796546162L;
}
