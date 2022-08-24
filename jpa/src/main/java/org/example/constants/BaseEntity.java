package org.example.constants;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -7616034474163386081L;
    @TableId(type = IdType.ASSIGN_ID)
    protected String id;

    @TableField(fill = FieldFill.INSERT)
    protected LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    protected LocalDateTime updateTime;
}
