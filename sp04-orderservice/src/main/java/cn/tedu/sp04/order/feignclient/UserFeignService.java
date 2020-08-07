package cn.tedu.sp04.order.feignclient;

import cn.tedu.sp01.pojo.User;
import cn.tedu.web.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="user-service",fallback = UserFeignServiceFB.class)
public interface UserFeignService {


    @GetMapping("/{userId}")
    JsonResult<User> getUesr(@PathVariable Integer userId);

    @PostMapping("/{userId}/score")
    JsonResult adScoer(@PathVariable Integer userId,Integer score);
}
