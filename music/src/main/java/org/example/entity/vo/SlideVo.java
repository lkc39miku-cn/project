package org.example.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.Album;
import org.example.entity.Slide;
@ApiModel(value="轮播图Vo")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(value = "handler")
public class SlideVo extends Slide {
private Album album;
}
