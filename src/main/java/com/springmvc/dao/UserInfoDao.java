package com.springmvc.dao;

import com.springmvc.entity.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/11/6 0006.
 */
@Repository("userInfoDao")
public class UserInfoDao extends BaseDao {
    //添加详细信息
    public boolean addUserInfo(UserInfo userinfo){
        try {
            getSession().save(userinfo);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
