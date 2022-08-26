package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;

import java.io.Serial;

@ApiModel(value="商品评论")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class CommodityComment extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -5271517374757102893L;
    @ApiModelProperty(value = "商品id")
    protected String commodityId;

    @ApiModelProperty(value = "用户id")
    protected String userId;

    @ApiModelProperty(value = "评论内容")
    protected String context;

    @ApiModelProperty(value = "评论图片")
    protected String contextImg;

    @ApiModelProperty(value = "回复人id")
    protected String toUserId;

    @ApiModelProperty(value = "显示状态 0 不显示 1 显示")
    protected Integer publishStatus;

    @ApiModelProperty(value = "删除状态 0 未删除 1 已删除")
    protected Integer deleteStatus;

    @ApiModelProperty(value = "上级评论的编号 0表示没有上级评论")
    protected String parentId;

}
