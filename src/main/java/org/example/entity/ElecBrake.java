package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;

@Data
//get() set()

@AllArgsConstructor
//全参构造器

@NoArgsConstructor
//无参构造器

//@ToString


@ApiModel("用户对象")
//swagger上标记用途

@EntityScan
public class ElecBrake {
    private Integer zId;
    private String uId;
    private Integer status;
    private Float u;
    private Float i;
    private Float p;
    private Float w;
    private Float t;
    private Date createTime;
    private Date updateTime;
}
