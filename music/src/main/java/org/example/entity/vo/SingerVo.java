package org.example.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.Album;
import org.example.entity.Singer;
import org.example.entity.User;

@ApiModel(value="歌手Vo")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(value = "handler")
public class SingerVo extends Singer {
    private User user;
}
