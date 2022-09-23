package org.example.entity;

import io.grpc.ManagedChannelProvider;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author zy
 */


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
public class User {
    private String uId;
    private String uPassword;
    private String uName;
    private boolean uGender;
    private String uTelephone;
    private Integer elecCharge;

}
