package cn.tedu.rs.m1;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Ljz
 * @date   2020-08-08
 */
@Component
public class Producer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        amqpTemplate.convertAndSend("Helloworld","  MJ  "+System.currentTimeMillis());
        System.out.println("消息已发送!");
    }

}
