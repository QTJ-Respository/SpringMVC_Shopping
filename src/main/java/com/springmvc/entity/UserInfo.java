package com.springmvc.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/11/6 0006.
 */
@Entity
@Table(name = "tb_userinfo")
public class UserInfo implements Serializable{

    private int u_no;
    private String u_name;
    private String u_sex;
    private String u_tel;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String u_Birth;
    private String u_email;
    private String u_img;
    //配置一对一
    private User user;

    public UserInfo() {
    }
    public UserInfo(int u_no, String u_name, String u_sex, String u_tel, String u_Birth, String u_email, String u_img) {
        this.u_no = u_no;
        this.u_name = u_name;
        this.u_sex = u_sex;
        this.u_tel = u_tel;
        this.u_Birth = u_Birth;
        this.u_email = u_email;
        this.u_img = u_img;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getU_no() {
        return u_no;
    }

    public void setU_no(int u_no) {
        this.u_no = u_no;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_sex() {
        return u_sex;
    }

    public void setU_sex(String u_sex) {
        this.u_sex = u_sex;
    }

    public String getU_tel() {
        return u_tel;
    }

    public void setU_tel(String u_tel) {
        this.u_tel = u_tel;
    }

    public String getU_Birth() {
        return u_Birth;
    }

    public void setU_Birth(String u_Birth) {
        this.u_Birth = u_Birth;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public String getU_img() {
        return u_img;
    }

    public void setU_img(String u_img) {
        this.u_img = u_img;
    }

    @OneToOne(cascade=CascadeType.REFRESH,fetch= FetchType.EAGER)
    @JoinColumn(name="uino")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
