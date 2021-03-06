package cn.tedu.sp09.controller;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.pojo.Order;
import cn.tedu.sp01.pojo.User;
import cn.tedu.sp09.feign.ItemFeignClient;
import cn.tedu.sp09.feign.OrderFeignClient;
import cn.tedu.sp09.feign.UserFeignClient;
import cn.tedu.web.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Ljz
 * @Date   : 2020-08-03
 */
@RestController
public class FeignController {

    @Autowired
    private ItemFeignClient itemFeignClient;
    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private OrderFeignClient orderFeignClient;


    @GetMapping("/item-service/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId){
        return itemFeignClient.getItems(orderId);
    }
    @PostMapping("/item-service/decreaseNumber")
    public JsonResult decreaseNumber(@RequestBody List<Item> items) {
        return itemFeignClient.decreaseNumber(items);
    }

    //====================================================================

    @GetMapping("/user-service/{userId}")
    public JsonResult<User> getUser(@PathVariable Integer userId){
        return userFeignClient.getUser(userId);
    }
    @PostMapping("/user-service/{userId}/score")
    public JsonResult addScore(@PathVariable Integer userId,Integer score){
        return userFeignClient.addScore(userId,score);
    }

    //====================================================================

    @GetMapping("/order-service/{orderId}")
    public JsonResult<Order> getOrder(@PathVariable String orderId){
        return orderFeignClient.getOrder(orderId);
    }
    @PostMapping("/order-service")
    public JsonResult<?> addOrder(){
        return orderFeignClient.addOrder();
    }
}
