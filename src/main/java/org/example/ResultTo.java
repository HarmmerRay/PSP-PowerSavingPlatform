package org.example;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "ResultTo", description = "返回断电类型")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultTo{

    @ApiModelProperty(value = "返回时间", example = "13.04")
    private String time;

    @ApiModelProperty(value = "返回信息", example = "设置成功，将在x时x分断电")
    private String msg;


}
