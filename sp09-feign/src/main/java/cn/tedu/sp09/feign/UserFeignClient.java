package cn.tedu.sp09.feign;

import cn.tedu.sp01.pojo.Order;
import cn.tedu.sp01.pojo.User;
import cn.tedu.web.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
/**
 * @author : Ljz
 * @Date   : 2020-08-03
 */
@FeignClient(name="user-service",fallback = UserFeignClientFB.class)
public interface UserFeignClient {

    @GetMapping("/{userId}")
    JsonResult<User> getUser(@PathVariable Integer userId);

    @PostMapping("/{userId}/score")
    JsonResult addScore(@PathVariable Integer userId,Integer score);

}
