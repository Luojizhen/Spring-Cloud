package cn.tedu.sp04.order.feignclient;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.web.util.JsonResult;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
/**
 * @author Ljz
 * @Date   2020-08-03
 */
@Component
public class ItemFeignServiceFB implements ItemFeignService {
    @Override
    public JsonResult<List<Item>> getItems(String orderId) {
        double sum = 0.5;
        if(Math.random()<sum){
            return JsonResult.ok().data(

                    Arrays.asList(new Item[]{
                            new Item(1,"缓存a",2),
                            new Item(2,"缓存b",1),
                            new Item(3,"缓存c",3),
                            new Item(4,"缓存d",1),
                            new Item(5,"缓存e",5)

                    })
            );
        }
        return JsonResult.err("无法获取订单商品列表!");
    }

    @Override
    public JsonResult decreaseNumber(List<Item> items) {
        return JsonResult.err("无法修改商品库存!");
    }

}
