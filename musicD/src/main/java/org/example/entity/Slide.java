package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 轮播图表
 * @TableName slide
 */
@TableName(value ="slide")
@Data
public class Slide implements Serializable {
    /**
     * id
     */
    @TableId(value = "id")
    private String id;

    /**
     * 轮播图路径
     */
    @TableField(value = "img")
    private String img;

    /**
     * 专辑id
     */
    @TableField(value = "album_id")
    private String albumId;

    /**
     * 是否有效
     */
    @TableField(value = "val_id")
    private String valId;

    /**
     * 创建人
     */
    @TableField(value = "create_staff_id")
    private String createStaffId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}