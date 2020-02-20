package com.gree.bdc.shiro.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "tuser")
public class Tuser implements Serializable {
    @Id
    @Column(name = "userId")
    @GeneratedValue(generator = "JDBC")
    private Integer userid;

    @Column(name = "mailNum")
    private String mailnum;

    @Column(name = "openid")
    private String openid;

    @Column(name = "sessionKey")
    private String sessionkey;

    /**
     * 用户名
     */
    @Column(name = "userName")
    private String username;

    /**
     * 部门
     */
    @Column(name = "userDepart")
    private String userdepart;

    /**
     * 密码
     */
    @Column(name = "`password`")
    private String password;

    @Column(name = "createTime")
    private String createtime;

    @Column(name = "createByWho")
    private String createbywho;

    @Column(name = "updateTime")
    private String updatetime;

    @Column(name = "updateByWho")
    private String updatebywho;

    /**
     * 用户状态
     */
    @Column(name = "isAvalible")
    private Integer isavalible;

    /**
     * 部门编号
     */
    @Column(name = "departmentId")
    private Integer departmentid;

    private static final long serialVersionUID = 1L;
}