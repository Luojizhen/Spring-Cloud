package cn.tedu.sp09.feign;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.pojo.Order;
import cn.tedu.web.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
/**
 * @author : Ljz
 * @Date   : 2020-08-03
 */
@FeignClient(name="order-service",fallback = OrderFeignClientFB.class)
public interface OrderFeignClient {

    @GetMapping("/{orderId}")
    JsonResult<Order> getOrder(@PathVariable String orderId);

    @PostMapping("/")
    JsonResult<?> addOrder();

}
