package org.example.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@TableName(value ="user_list")
@Data
@Accessors(chain = true)
@ApiModel(value = "用户收藏歌单表")
public class UserList implements Serializable {

    @Serial
    private static final long serialVersionUID = 1751274733569989363L;

    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户id")
    private String userId;

    @TableField(value = "list_id")
    @ApiModelProperty(value = "歌单id")
    private String listId;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "歌单收藏时间")
    private LocalDateTime createTime;
}