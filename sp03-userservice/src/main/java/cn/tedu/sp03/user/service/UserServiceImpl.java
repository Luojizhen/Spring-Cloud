package cn.tedu.sp03.user.service;

import cn.tedu.sp01.pojo.User;
import cn.tedu.sp01.service.UserService;
import cn.tedu.web.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Value("${sp.user-service.users}")
    private String userJson;


    /**
     * 查询用户列表
     * @param id 用户 id
     * @return
     */
    @Override
    public User getUser(Integer id) {
        List<User> users = JsonUtil.from(userJson, new TypeReference<List<User>>() {
        });

        for (User user: users) {
            if(id.equals(user.getId())){
                return user;
            }
        }
        return new User(id,"name"+id,"pwd"+id);
    }


    /**
     * 增加用户的积分
     * @param id    用户 id
     * @param score 积分
     */
    @Override
    public void addScore(Integer id, Integer score) {
        log.info("user"+id+" - 增加积分 "+ score);
    }
}
