package org.example.entity;

import io.swagger.annotations.ApiModel;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

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

@Data
public class Socket extends Brake{
    private Integer cid;
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
}
