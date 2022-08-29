package org.example.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.User;

@ApiModel(value="UserVo")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(value = "handler")
public class UserVo extends User {

}
