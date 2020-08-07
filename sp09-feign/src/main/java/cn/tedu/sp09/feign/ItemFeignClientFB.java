package cn.tedu.sp09.feign;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.web.util.JsonResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component  //表示交给spring管理
public class ItemFeignClientFB implements ItemFeignClient{

    /**
     * 添加降级后商品列表的处理方法
      * @param orderId
     * @return
     */
    @Override
    public JsonResult<List<Item>> getItems(String orderId) {
        return JsonResult.err("无法获取订单商品列表信息!!!");
    }


    @Override
    public JsonResult decreaseNumber(List<Item> items) {
        return JsonResult.err("无法修改商品库存!!!");
    }
}
