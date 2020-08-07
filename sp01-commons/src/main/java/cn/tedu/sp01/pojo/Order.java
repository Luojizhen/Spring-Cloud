package cn.tedu.sp01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ljz
 * @Date 2020-07-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String id;
    private User user;
    private List<Item> items;
}