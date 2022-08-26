package org.example.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;
import java.io.Serial;

@ApiModel(value="用户的评论状态")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class UserCommentStatus extends BaseEntity{
    @Serial
    private static final long serialVersionUID = 8972663260988954031L;


    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "用户评论状态")
    private String commentStatus;

    @ApiModelProperty(value = "禁用提示")
    private String commentInfo;

    @ApiModelProperty(value = "禁言开始时间")
    private String commentStartTime;

    @ApiModelProperty(value = "禁言结束时间")
    private String commentEndTime;

    @ApiModelProperty(value = "操作人id")
    private String StaffId;
}
