package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value="菜单")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Menu extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 2983932564494438529L;

    @ApiModelProperty(value="菜单名称")
    private String name;

    @ApiModelProperty(value="父菜单ID")
    private String parentId;

    @ApiModelProperty(value="显示顺序")
    private Integer menuOrder;

    @ApiModelProperty(value="路由地址")
    private String path;

    @ApiModelProperty(value="组件路径")
    private String component;

    @ApiModelProperty(value="路由参数")
    private String query;

    @ApiModelProperty(value="是否为外链 0是 1否")
    private Integer isFrame;

    @ApiModelProperty(value="是否缓存 0缓存 1不缓存")
    private Integer isCache;

    @ApiModelProperty(value="菜单类型 M目录 C菜单 F按钮")
    private String type;

    @ApiModelProperty(value="菜单状态 0显示 1隐藏")
    private Integer visible;

    @ApiModelProperty(value="菜单状态 0正常 1停用")
    private Integer status;

    @ApiModelProperty(value="权限标识")
    private String perms;

    @ApiModelProperty(value="菜单图标")
    private String icon;

    @ApiModelProperty(value="创建者Id")
    private String createStaffId;

    @ApiModelProperty(value="备注")
    private String remark;
}
