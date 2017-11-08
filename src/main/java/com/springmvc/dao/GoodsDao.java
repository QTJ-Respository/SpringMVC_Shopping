package com.springmvc.dao;

import com.springmvc.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/11/7 0007.
 */
@Repository("goodsDao")
public class GoodsDao  extends BaseDao{
    //添加商品
    public boolean addGoods(Goods goods){
        try {
            getSession().save(goods);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    //模糊查询商品
    public List findLike(String hql){
        return getSession().createQuery(hql).list();
    }
    //查询所有商品
    public List showAllGoods(String hql){
        return getSession().createQuery(hql).list();
    }
    //根据ID查询
    public Goods findGoodsById(int gid){
        Goods g = getSession().get(Goods.class,gid);
        return g;
    }
    //上架
    public boolean updateUP(Goods goods){
        try {
            getSession().update(goods);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
