package com.springmvc.dao;

import com.springmvc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/11/6 0006.
 */
@Repository("userDao")
public class UserDao extends BaseDao {
    //添加用户
    public boolean addUser(User user){
        try {
            getSession().save(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    //根据ID查询
    public User findUserbyId(int id){
        return getSession().get(User.class,id);
    }
    //登录查询
    public List findUser(String hql){
        return getSession().createQuery(hql).list();
    }
}
