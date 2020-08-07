package cn.tedu.sp04.order.service;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.pojo.Order;
import cn.tedu.sp01.pojo.User;
import cn.tedu.sp01.service.OrderService;
import cn.tedu.sp04.order.feignclient.ItemFeignService;
import cn.tedu.sp04.order.feignclient.UserFeignService;
import cn.tedu.web.util.JsonResult;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ljz
 * @Date   2020-08-03
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserFeignService userService;

    @Autowired
    private ItemFeignService itemService;
    /**
     * 获取订单
     * @param orderId
     * @return
     */
    @Override
    public Order getOrder(String orderId) {
        //TODO: 调用user-service获取用户信息
        JsonResult<User> user = userService.getUesr(7);

        //TODO: 调用item-service获取商品信息
        JsonResult<List<Item>> items = itemService.getItems(orderId);

        Order order = new Order();
        order.setId(orderId);
        order.setUser(user.getData());
        order.setItems(items.getData());
        return order;
    }
    
    /**
     * 添加订单
     * @return
     */
    @Override
    public void addOrder(Order order) {
        //TODO: 调用item-service减少商品库存
        itemService.decreaseNumber(order.getItems());

        //TODO: 调用user-service增加用户积分
        userService.adScoer(7,100);

        log.info("保存订单："+order);
    }
}
