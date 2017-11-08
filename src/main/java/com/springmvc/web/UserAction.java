package com.springmvc.web;

import com.springmvc.entity.User;
import com.springmvc.entity.UserInfo;
import com.springmvc.service.UserInfoService;
import com.springmvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/11/6 0006.
 */
@Controller
@RequestMapping("/userAction")
@SessionAttributes({"uname"})
public class UserAction {

    //注入UserService
    @Resource(name="userService")
    private UserService userService;
    //注入UserInfoService
    @Resource(name = "userInfoService")
    private UserInfoService userInfoService;

    //查询登录用户
    @RequestMapping("/doLogin")
    public String doLogin(User user, HttpSession session, PrintWriter out){
        System.out.println(user.getUname());
        if(userService.findUser(user)!=null){
            session.setAttribute("user",user);
            return "redirect:/ShoppingInfo.jsp";
        }else{
            out.print("<script>alert('Logon failure');</script>");
            return "index";
        }
    }
    //添加用户的方法
    @RequestMapping("/addUser")
    public String addUser(User user, HttpServletRequest request){
        System.out.println(user.getUname()+":"+user.getUpwd());
        if(userService.addUser(user)){
            request.setAttribute("user",user);
            return "Personal_information";
        }else{
            return "User_Register";
        }
    }
    //上传文件方法
    @RequestMapping("/uploadFile")
    public String uploadFile(MultipartFile ufile, UserInfo user, HttpSession session){
        System.out.println("用户名:"+user.getU_name());
        System.out.println("UserID:"+user.getUser().getUno());
        //上传文件
        if(!ufile.isEmpty()){
            //获取服务器路径
            String basePath=session.getServletContext().getRealPath("/images");
            String realName=ufile.getOriginalFilename();//真实上传的文件名
            //执行上传操作
            try {
                ufile.transferTo(new File(basePath+"/"+realName));
                System.out.println("上传路径:"+basePath+"/"+realName);
                user.setU_img(basePath+"/"+realName);
                if(userInfoService.addUserInfo(user)){
                    return "redirect:/Personal_information.jsp";
                }else{
                    return "Personal_information";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }
}
