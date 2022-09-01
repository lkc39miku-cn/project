package org.example.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.User;
import org.example.entity.UserAddress;

import java.io.Serial;

@ApiModel(value="用户地址Vo")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(value = "handler")
public class UserAddressVo extends UserAddress {
    @Serial
    private static final long serialVersionUID = 2915405164195701005L;

    @ApiModelProperty(value = "用户")
    private User user;
}
