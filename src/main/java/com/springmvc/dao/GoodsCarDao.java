package com.springmvc.dao;

import com.springmvc.entity.GoodsCar;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/11/7 0007.
 */
@Repository("goodsCarDao")
public class GoodsCarDao extends BaseDao {
    //添加订单
    public boolean addGoodsCar(GoodsCar goodsCar){
        try {
            getSession().save(goodsCar);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    //查询所有订单
    public List findOrder(String hql){
        return getSession().createQuery(hql).list();
    }
}
