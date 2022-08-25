package org.example.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@TableName(value ="user_song")
@Data
@Accessors(chain = true)
@ApiModel(value = "用户收藏歌曲表")
public class UserSong implements Serializable {

    @Serial
    private static final long serialVersionUID = 8251961428835005002L;

    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户id")
    private String userId;

    @TableField(value = "song_id")
    @ApiModelProperty(value = "歌曲id")
    private String songId;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "收藏时间")
    private LocalDateTime createTime;
}