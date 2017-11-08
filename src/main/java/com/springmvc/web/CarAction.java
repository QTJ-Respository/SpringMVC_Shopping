package com.springmvc.web;

import com.springmvc.entity.GoodsCar;
import com.springmvc.service.GoodsCarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/11/7 0007.
 */
@Controller
@RequestMapping("/carAction")
public class CarAction {
    //注入CarService
    @Resource(name = "goodsCarService")
    private GoodsCarService goodsCarService;

    @RequestMapping("/addGoodsCar")
    public String addGoodsCar(GoodsCar goodsCar,int gid){
        System.out.println(goodsCar.getC_num()+":"+gid);
        if(goodsCarService.addGoodsCar(goodsCar,gid)){
            return "ShoppingInfo";
        }
        return "ShoppingInfo";
    }
    //查询所有订单
    @RequestMapping("/findOrder")
    @ResponseBody
    public List findOrder(){
        return goodsCarService.findOrder();
    }

    public void setGoodsCarService(GoodsCarService goodsCarService) {
        this.goodsCarService = goodsCarService;
    }
}
