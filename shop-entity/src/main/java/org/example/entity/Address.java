package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;
import java.io.Serial;
import java.io.Serializable;

@ApiModel(value="地址")
@Data
@Accessors(chain = true)
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = 7287153707164496373L;

    @ApiModelProperty(value = "地址名称")
    protected String name;

    @ApiModelProperty(value = "地址的上级 0 表示无上级")
    protected String parentId;

}
