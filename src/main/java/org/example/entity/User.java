package org.example.entity;

import io.swagger.annotations.ApiModel;
import lombok.*;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;

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


public class User implements Serializable {

    //数据库中的名字都是uid upassword没有 aA格式

    private String uid;
    private String upassword;
    private String uname;
    private boolean ugender;
    private String utelephone;
    private Integer elecCharge;

    /**
     * 因为boolean类型自动注入，get和set方法 分别是 is 和 set 所以自定义get set
     * @return
     */
    public boolean getUgender() {
        return ugender;
    }

    public void setUgender(boolean ugender) {
        this.ugender = ugender;
    }

}
