package com.springmvc.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/6 0006.
 */
@Entity
@Table(name = "tb_goods")
public class Goods implements Serializable {
    private int gno;
    private String gname;
    private double gprice;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date gintime;
    private String ghome;
    private int gstate;//1:上架，2：下架
    private String gimg;

    //一个物品一个订单
    private GoodsCar goodsCar;
    public Goods() {
    }


    public Goods(int gno, String gname, double gprice, Date gintime, String ghome, int gstate, String gimg, GoodsCar goodsCar) {
        this.gno = gno;
        this.gname = gname;
        this.gprice = gprice;
        this.gintime = gintime;
        this.ghome = ghome;
        this.gstate = gstate;
        this.gimg = gimg;
        this.goodsCar = goodsCar;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getGno() {
        return gno;
    }

    public void setGno(int gno) {
        this.gno = gno;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public double getGprice() {
        return gprice;
    }

    public void setGprice(double gprice) {
        this.gprice = gprice;
    }

    public Date getGintime() {
        return gintime;
    }

    public void setGintime(Date gintime) {
        this.gintime = gintime;
    }

    public String getGhome() {
        return ghome;
    }

    public void setGhome(String ghome) {
        this.ghome = ghome;
    }

    public int getGstate() {
        return gstate;
    }

    public void setGstate(int gstate) {
        this.gstate = gstate;
    }

    public String getGimg() {
        return gimg;
    }

    public void setGimg(String gimg) {
        this.gimg = gimg;
    }

    @OneToOne(cascade = CascadeType.ALL,mappedBy="goods")
    public GoodsCar getGoodsCar() {
        return goodsCar;
    }

    public void setGoodsCar(GoodsCar goodsCar) {
        this.goodsCar = goodsCar;
    }
}
