package cn.tedu.sp02.item.controller;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.web.util.JsonResult;
import cn.tedu.sp01.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

/**
 * @author Ljz
 * @Date 2020-07-28
 */
@Slf4j
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Value("${server.port}")
    private int port;

    /**
     * 获取订单中的商品
     *
     * @param orderId 订单 id
     * @return 商品集合
     */
    @GetMapping("/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId) throws Exception {
        log.info("server.port=" + port + ", orderId=" + orderId);

        ///--设置随机延迟
        long t = new Random().nextInt(5000);
        if(Math.random()<0.6) {
            log.info("item-service-"+port+" - 暂停 "+t);
            Thread.sleep(t);
            System.out.println("延迟: "+t);
        }
        ///~~

        List<Item> items = itemService.getItems(orderId);
        return JsonResult.ok(items).msg("port=" + port);
    }

    /**
     * 减少商品库存
     *
     * @param items 商品集合
     * @return JsonResult
     */
    @PostMapping("/decreaseNumber")
    public JsonResult decreaseNumber(@RequestBody List<Item> items) {
        itemService.decreaseNumbers(items);
        return JsonResult.ok().msg("减少商品库存成功");
    }

}