package org.example.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.Menu;
import org.example.entity.Staff;

import java.io.Serial;
import java.util.List;

@ApiModel(value="菜单Vo")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(value = "handler")
public final class MenuVo extends Menu {
    @Serial
    private static final long serialVersionUID = -7810459778569093639L;

    @ApiModelProperty(value = "添加人")
    private Staff createStaff;

    @ApiModelProperty(value = "子菜单")
    private List<MenuVo> children;

    @ApiModelProperty(value = "是否选中")
    private boolean checked;
}
