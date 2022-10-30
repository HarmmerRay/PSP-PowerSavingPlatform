package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.models.auth.In;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zy
 */
@Getter
@Setter
//get() set()

@AllArgsConstructor
//全参构造器

@NoArgsConstructor
//无参构造器

//@ToString


@ApiModel("用户对象")
//swagger上标记用途


public class ElecBrake extends Brake implements Serializable {
    private Integer zid;
    private String uid;
    private Integer status;
    private Float u;
    private Float i;
    private Float p;
    private Float w;
    private Float t;
    private Date createTime;
    private Date updateTime;

    @Override
    public String toString() {
        return "ElecBrake{" +
                "zid=" + zid +
                ", uid='" + uid + '\'' +
                ", status=" + status +
                ", u=" + u +
                ", i=" + i +
                ", p=" + p +
                ", w=" + w +
                ", t=" + t +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
