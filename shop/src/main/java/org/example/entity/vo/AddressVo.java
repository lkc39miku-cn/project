package org.example.entity.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.Address;

import java.io.Serial;

@ApiModel(value="部门Vo")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(value = "handler")
public class AddressVo extends Address {
    @Serial
    private static final long serialVersionUID = -5302349466820596459L;


}
