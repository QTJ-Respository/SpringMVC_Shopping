package com.springmvc.service;

import com.springmvc.dao.UserDao;
import com.springmvc.dao.UserInfoDao;
import com.springmvc.entity.User;
import com.springmvc.entity.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/11/6 0006.
 */
@Service("userInfoService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserInfoService {
    //注入userinfoDao
    @Resource( name = "userInfoDao")
    private UserInfoDao userInfoDao;
    //注入UserDao
    @Resource(name="userDao")
    private UserDao userDao;

    //添加用户详情
    public boolean addUserInfo(UserInfo userinfo){
        //查询ID为UserInfo...的用户
        User user =  userDao.findUserbyId(userinfo.getUser().getUno());
        userinfo.setUser(user);
        return userInfoDao.addUserInfo(userinfo);
    }

    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
