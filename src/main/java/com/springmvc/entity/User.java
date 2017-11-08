package com.springmvc.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/11/6 0006.
 */
@Entity
@Table(name = "tb_user")
public class User implements Serializable{

    private int uno;
    private String uname;
    private String upwd;
    //配置一对一
    private UserInfo userInfo;

    public User() {
    }

    public User(int uno, String uname, String upwd) {
        this.uno = uno;
        this.uname = uname;
        this.upwd = upwd;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getUno() {
        return uno;
    }

    public void setUno(int uno) {
        this.uno = uno;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="user")
    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
