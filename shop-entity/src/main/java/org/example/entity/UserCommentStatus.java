package org.example.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;
import java.io.Serial;
import java.time.LocalDateTime;

@ApiModel(value="用户评论状态")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class UserCommentStatus extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 4939566083506442052L;
    @ApiModelProperty(value = "用户id")
    protected String userId;

    @ApiModelProperty(value = "用户评论状态 0 正常 1 禁用")
    protected Integer commentStatus;

    @ApiModelProperty(value = "禁用提示")
    protected String commentInfo;

    @ApiModelProperty(value = "禁言开始时间")
    protected LocalDateTime commentStartTime;

    @ApiModelProperty(value = "禁言结束时间")
    protected LocalDateTime commentEndTime;

    @ApiModelProperty(value = "操作人id")
    protected String StaffId;
}
