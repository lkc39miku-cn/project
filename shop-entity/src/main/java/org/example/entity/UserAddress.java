package org.example.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;
import java.io.Serial;

@ApiModel(value="用户地址")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class UserAddress extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 6261472153674403495L;
    @ApiModelProperty(value = "用户id")
    protected String userId;

    @ApiModelProperty(value = "用户手机号")
    protected String phone;

    @ApiModelProperty(value = "地址id")
    protected String addressId;

    @ApiModelProperty(value = "详细地址")
    protected String addressInfo;

    @ApiModelProperty(value = "地址是否默认 0 不是 1 是")
    protected Integer addressStatus;

}
