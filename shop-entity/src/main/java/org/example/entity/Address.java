package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;
import java.io.Serial;

@ApiModel(value="地址")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Address extends BaseEntity{
    @Serial
    private static final long serialVersionUID = 8972663260988954031L;

    @ApiModelProperty(value = "地址名称")
    private String name;

    @ApiModelProperty(value = "地址的上级0表示无上级")
    private String parentId;

}
