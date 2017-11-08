package com.springmvc.service;

import com.springmvc.dao.GoodsCarDao;
import com.springmvc.dao.GoodsDao;
import com.springmvc.entity.Goods;
import com.springmvc.entity.GoodsCar;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/11/7 0007.
 */
@Service("goodsCarService")
@Transactional(propagation = Propagation.REQUIRED)
public class GoodsCarService {
    //注入CarDao
    @Resource(name = "goodsCarDao")
    private GoodsCarDao goodsCarDao;
    //注入GoodsDao
    @Resource(name = "goodsDao")
    private GoodsDao goodsDao;

    //添加订单
    public boolean addGoodsCar(GoodsCar goodsCar,int gno){
        Goods goods = goodsDao.findGoodsById(gno);
        goodsCar.setGoods(goods);
        return goodsCarDao.addGoodsCar(goodsCar);
    }
    //查询所有订单
    public List findOrder(){
        String hql = "from GoodsCar";
        return goodsCarDao.findOrder(hql);
    }

    public void setGoodsCarDao(GoodsCarDao goodsCarDao) {
        this.goodsCarDao = goodsCarDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }
}
