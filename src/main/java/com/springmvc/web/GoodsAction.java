package com.springmvc.web;

import com.springmvc.entity.Goods;
import com.springmvc.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/11/7 0007.
 */
@Controller
@RequestMapping("/goodsAction")
public class GoodsAction {

    public List goodsList;
    //注入服务层
    @Resource(name = "goodsService")
    private GoodsService goodsService;

    //模糊查询
    @RequestMapping("/LikeSelect")
    public String LikeSelect(String goodsname,double goodsprice){
        //System.out.println(goodsname+goodsprice);
        List goodsList = goodsService.showlikeGoods(goodsname,goodsprice);
        System.out.println("goodslist:;"+goodsList);
        return null;
    }
    //商品上架
    @RequestMapping("/GoodsUP")
    public String GoodsUP(int gid){
        Goods goods = goodsService.findGoodsById(gid);
        goods.setGstate(0);
        if(goodsService.goodsUP(goods)){
            return "redirect:/ShowAllGoods.jsp";
        }
       return "redirect:/ShowAllGoods.jsp";
    }
    //商品下架
    @RequestMapping("/GoodsDown")
    public String GoodsDown(int gid){
        Goods goods = goodsService.findGoodsById(gid);
        goods.setGstate(1);
        if(goodsService.goodsUP(goods)){
            return "redirect:/ShowAllGoods.jsp";
        }
        return "redirect:/ShowAllGoods.jsp";
    }


    //查询ID商品
    @RequestMapping("/findIDGoods")
    public String updateGoods(int gid, HttpServletRequest request){
        //查询出该编号的商品
        Goods goods = goodsService.findGoodsById(gid);
        request.setAttribute("goods",goods);
        return "GoodsCar";
    }

    //查询所有商品
    @RequestMapping("/showAllGoods")
    @ResponseBody
    public List showAllGoods(){
        System.out.println(goodsService.showAddGoods());
        return goodsService.showAddGoods();
    }

    //上传文件方法
    @RequestMapping("/addGoods")
    public String uploadFile(MultipartFile ufile, Goods goods, HttpSession session,RedirectAttributes attr){
        System.out.println("商品名:"+ goods.getGname());
        //System.out.println("商品ID:"+goods.getGoodsCar().getC_no());
        //上传文件
        if(!ufile.isEmpty()){
            //获取服务器路径
            String basePath=session.getServletContext().getRealPath("/images");
            String realName=ufile.getOriginalFilename();//真实上传的文件名
            //执行上传操作
            try {
                ufile.transferTo(new File(basePath+"/"+realName));
                System.out.println("上传路径:"+"/"+realName);
                goods.setGimg("/"+realName);
                if(goodsService.addGoods(goods)){
                    attr.addAttribute("rtype","1");
                }else{
                    attr.addAttribute("rtype","-1");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/addGoods.jsp";
    }

    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    public List getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List goodsList) {
        this.goodsList = goodsList;
    }
}
