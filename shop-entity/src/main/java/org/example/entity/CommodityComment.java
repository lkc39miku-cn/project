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
    private static final long serialVersionUID = 8972663260988954031L;

    @ApiModelProperty(value = "商品id")
    private String commodityId;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "评论内容")
    private String context;

    @ApiModelProperty(value = "评论图片")
    private String contextImg;

    @ApiModelProperty(value = "回复人id")
    private String toUserId;

    @ApiModelProperty(value = "显示状态")
    private String publishStatus;

    @ApiModelProperty(value = "删除状态")
    private String deleteStatus;

    @ApiModelProperty(value = "上级评论的编号")
    private String parentId;

}
