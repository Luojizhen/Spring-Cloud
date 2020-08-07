package cn.tedu.sp09.feign;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.pojo.Order;
import cn.tedu.web.util.JsonResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component  //表示交给spring管理
public class OrderFeignClientFB implements OrderFeignClient{


    /**
     * 添加降级后订单信息处理方法
     * @param orderId
     * @return
     */
    @Override
    public JsonResult<Order> getOrder(String orderId) {
        return JsonResult.err("无法获取订单信息!!!");
    }


    @Override
    public JsonResult<?> addOrder() {
        return JsonResult.err("无法保存订单!!!");
    }
}
