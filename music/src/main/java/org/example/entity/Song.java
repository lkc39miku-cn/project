package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;

@TableName(value ="song")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "歌曲表")
public class Song extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 3270773343320794428L;

    @TableField(value = "name")
    @ApiModelProperty(value = "歌曲名")
    private String name;

    @TableField(value = "singer")
    @ApiModelProperty(value = "歌手id")
    private String singerId;

    @TableField(value = "img")
    @ApiModelProperty(value = "歌曲图片路径")
    private String img;

    @TableField(value = "file_path")
    @ApiModelProperty(value = "歌曲文件路径")
    private LocalDateTime filePath;

    @TableField(value = "album_id")
    @ApiModelProperty(value = "专辑id")
    private String albumId;

    @TableField(value = "lyc")
    @ApiModelProperty(value = "歌词")
    private String lyc;

    @TableField(value = "remark")
    @ApiModelProperty(value = "备注")
    private String remark;
}