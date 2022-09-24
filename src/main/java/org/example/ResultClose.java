package org.example;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "ResultClose", description = "返回结果")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultClose {

    @ApiModelProperty(value = "状态值", example = "o")
    private Integer state;

}

