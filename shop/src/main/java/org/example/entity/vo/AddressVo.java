package org.example.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.Address;

import java.io.Serial;
import java.util.List;

@ApiModel(value="地址Vo")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(value = "handler")
public class AddressVo extends Address {
    @Serial
    private static final long serialVersionUID = 2271527202474233034L;
    private List<AddressVo> children;
}
