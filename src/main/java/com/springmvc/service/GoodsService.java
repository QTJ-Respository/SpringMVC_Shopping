package com.springmvc.service;

import com.springmvc.dao.GoodsDao;
import com.springmvc.entity.Goods;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/11/7 0007.
 */
@Service("goodsService")
@Transactional(propagation = Propagation.REQUIRED)
public class GoodsService {
    //注入Goods层
    @Resource(name = "goodsDao")
    private GoodsDao goodsDao;

    //模糊查询商品
    public List showlikeGoods(String name,double price){
        String hql = "from Goods where";
        if(name!=null){
            hql +=" gname like '%'"+name+"'%'";
        }
        if(price!=0){
            hql +=" and gprice < "+price+"";
        }
        System.out.println(hql);
        return goodsDao.findLike(hql);
    }
    //添加商品
    public boolean addGoods(Goods goods){
        return goodsDao.addGoods(goods);
    }
    //查询所有商品
    public List showAddGoods(){
        String hql = "from Goods";
        return goodsDao.showAllGoods(hql);
    }
    //根据ID查询商品
    public Goods findGoodsById(int gid){
        return goodsDao.findGoodsById(gid);
    }
    //上架
    public boolean goodsUP(Goods goods){
        return goodsDao.updateUP(goods);
    }
    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }
}
