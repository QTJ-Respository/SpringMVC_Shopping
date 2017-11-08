package com.springmvc.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/11/7 0007.
 */
@Entity
@Table(name = "goodsCar")
public class GoodsCar implements Serializable{
    private int c_no;
    private int c_num;

    //配置一对一
    private Goods goods;

    public GoodsCar() {
    }

    public GoodsCar(int c_no, int c_num) {
        this.c_no = c_no;
        this.c_num = c_num;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getC_no() {
        return c_no;
    }

    public void setC_no(int c_no) {
        this.c_no = c_no;
    }

    public int getC_num() {
        return c_num;
    }

    public void setC_num(int c_num) {
        this.c_num = c_num;
    }

    @OneToOne(cascade=CascadeType.REFRESH)
    @JoinColumn(name="cgid")
    public Goods getGoods() {
        return goods;
    }
    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
