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

@TableName(value ="slide")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "轮播图表")
public class Slide extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 6598244179795057146L;

    @TableField(value = "img")
    @ApiModelProperty(value = "轮播图路径")
    private String img;

    @TableField(value = "album_id")
    @ApiModelProperty(value = "专辑id")
    private String albumId;

    @TableField(value = "status")
    @ApiModelProperty(value = "是否有效 0无效 1有效")
    private Integer status;

    @TableField(value = "create_staff_id")
    @ApiModelProperty(value = "创建人id")
    private String createStaffId;

    @TableField(value = "start_time")
    @ApiModelProperty(value = "开始时间")
    private LocalDateTime startTime;

    @TableField(value = "end_time")
    @ApiModelProperty(value = "结束时间")
    private LocalDateTime endTime;

    @TableField(value = "remark")
    @ApiModelProperty(value = "备注")
    private String remark;
}