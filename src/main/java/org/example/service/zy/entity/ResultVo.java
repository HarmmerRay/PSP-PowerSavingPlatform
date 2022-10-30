package org.example.service.zy.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zy
 */
@ApiModel(value = "ResultVo", description = "公用返回结果Vo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVo {

    @ApiModelProperty(value = "状态码", example = "200")
    private Integer code;

    @ApiModelProperty(value = "返回信息", example = "success")
    private String msg;

    @ApiModelProperty(value = "返回数据", example = "data")
    private Object data;
}
