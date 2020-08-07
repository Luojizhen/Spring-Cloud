package cn.tedu.sp09.feign;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.pojo.User;
import cn.tedu.web.util.JsonResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component  //表示交给spring管理
public class UserFeignClientFB implements UserFeignClient{

    /**
     * 添加降级后用户信息处理方法
     * @param userId
     * @return
     */
    @Override
    public JsonResult<User> getUser(Integer userId) {
        return JsonResult.err("无法获取用户信息!!!");
    }

    /**
     * 添加降级后用户积分添加处理方法
     * @param userId
     * @param score
     * @return
     */
    @Override
    public JsonResult addScore(Integer userId, Integer score) {
        return JsonResult.err("无法增加用户积分!!!");
    }
}
