package org.example.entity;

import io.grpc.ManagedChannelProvider;
import io.swagger.annotations.ApiModel;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

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
public class User {

    //数据库中的名字都是uid upassword没有 aA格式

    private String uid;
    private String upassword;
    private String uname;
    private boolean ugender;
    private String utelephone;
    private Integer elecCharge;

}
