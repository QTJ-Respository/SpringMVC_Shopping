package com.springmvc.service;

import com.springmvc.dao.UserDao;
import com.springmvc.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/11/6 0006.
 */
@Service("userService")
@SuppressWarnings("unchecked")
@Transactional(propagation = Propagation.REQUIRED)
public class UserService {
    //注入UserDao
    @Resource(name = "userDao")
    private UserDao userDao;

    //查询登录用户
    public User findUser(User user){
        String hql = "from User where uname = '"+user.getUname()+"'";
        List<User> userList = userDao.findUser(hql);
        for (User u: userList) {
            if(user.getUname().equals(u.getUname()) && user.getUpwd().equals(u.getUpwd())){
                return u;
            }
        }
        return null;
    }
    //添加用户
    public boolean addUser(User user){
        return userDao.addUser(user);
    }


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
