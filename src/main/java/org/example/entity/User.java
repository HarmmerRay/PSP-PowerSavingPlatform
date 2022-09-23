package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "User实体类", description = "用户(User)实体类")

public class User implements Serializable{
    /** 用户id */
    @ApiModelProperty(value = "用户id")
    private String  uid;
    /** 密码 */
    @ApiModelProperty(value = "密码")
    private String upassword;
    /** 用户名 */
    @ApiModelProperty(value = "用户名")
    private String uname;
    /** 性别 */
    @ApiModelProperty(value = "性别")
    private Integer ugender;
    /** 电话 */
    @ApiModelProperty(value = "电话")
    private String utelephone;
    /** 电费 */
    @ApiModelProperty(value = "电费")
    private Integer elecCharge;

    public User() {
    }

    public User(String uid, String upassword, String uname, Integer ugender, String utelephone, Integer elecCharge) {
        this.uid = uid;
        this.upassword = upassword;
        this.uname = uname;
        this.ugender = ugender;
        this.utelephone = utelephone;
        this.elecCharge = elecCharge;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getUgender() {
        return ugender;
    }

    public void setUgender(Integer ugender) {
        this.ugender = ugender;
    }

    public String getUtelephone() {
        return utelephone;
    }

    public void setUtelephone(String utelephone) {
        this.utelephone = utelephone;
    }

    public Integer getElecCharge() {
        return elecCharge;
    }

    public void setElecCharge(Integer elecCharge) {
        this.elecCharge = elecCharge;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", upassword='" + upassword + '\'' +
                ", uname='" + uname + '\'' +
                ", ugender=" + ugender +
                ", utelephone='" + utelephone + '\'' +
                ", elecCharge=" + elecCharge +
                '}';
    }
}
