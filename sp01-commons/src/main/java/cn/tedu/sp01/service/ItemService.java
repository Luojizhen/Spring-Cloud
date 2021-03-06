package cn.tedu.sp01.service;

import java.util.List;

import cn.tedu.sp01.pojo.Item;

/**
 * @author ljz
 * @Date 2020-07-28
 */
public interface ItemService {

    /**
     * 查询订单中的商品列表
     *
     * @param orderId 订单 id
     * @return 商品列表
     */
    List<Item> getItems(String orderId);

    /**
     * 减少商品的库存
     *
     * @param list 商品列表
     */
    void decreaseNumbers(List<Item> list);
}
