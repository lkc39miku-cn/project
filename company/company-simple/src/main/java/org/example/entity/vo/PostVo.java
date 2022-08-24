package org.example.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.Post;
import org.example.entity.Staff;

import java.io.Serial;

@ApiModel(value="岗位Vo")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(value = "handler")
public final class PostVo extends Post {
    @Serial
    private static final long serialVersionUID = 7154514817466663214L;

    @ApiModelProperty(value="创建者")
    private Staff createStaff;
}
