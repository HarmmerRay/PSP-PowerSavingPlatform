package org.example.service.zy.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @author zy
 */
@ApiModel(value = "ResultTo", description = "返回断电类型")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultTo implements Serializable {

    @ApiModelProperty(value = "开始时间", example = "13:04")
    private String stime;

    @ApiModelProperty(value = "结束时间", example = "15:04")
    private String etime;

    @ApiModelProperty(value = "返回信息", example = "设置成功，将在x时x分断电")
    private String msg;


}
