package org.example.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;

@TableName(value ="song_list")
@Data
@Accessors(chain = true)
@ApiModel(value = "歌单歌曲中间表")
public class SongList implements Serializable {
    @Serial
    private static final long serialVersionUID = 549497296793499543L;

    @TableField(value = "list_id")
    @ApiModelProperty(value = "歌单id")
    private String listId;

    @TableField(value = "song_id")
    @ApiModelProperty(value = "歌曲id")
    private String songId;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
}