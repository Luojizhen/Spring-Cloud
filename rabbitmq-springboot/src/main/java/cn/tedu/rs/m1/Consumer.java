package cn.tedu.rs.m1;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author  Ljz
 * @date    2020-08-08
 * @RabbitListener : 指定的队列接收消息.
 * @RabbitHandler  : 指定处理消息的方法.
 *
 */
@Component
@RabbitListener(queues = "Helloworld")
public class Consumer {

    @RabbitHandler
    public void receive(String msg){
        System.out.println("收到: "+msg);
    }


}
