package cn.tedu.rs.m3;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lJZ
 * @date   2020-08-10
 */
@Component
public class Consumer {
    /**
     * @RabbitListener : 指定的队列接收消息,也可以直接用在方法上.
     * bindings = @QueueBinding() : 进行绑定设置
     * value = @Queue : 定义随机队列:非持久,独占,自动删除
     * @Exchange(name = "logs",declare = "false")) : 指定 logs交换机
     *
     */
    @RabbitListener(bindings = @QueueBinding(value = @Queue,exchange = @Exchange(name = "logs",declare = "false")))
    public void receiver1(String msg){
        System.out.println("receiver1 - 收到: "+ msg);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue,exchange = @Exchange(name = "logs",declare = "false")))
    public void receiver2(String msg){
        System.out.println("receiver2 - 收到: "+ msg);
    }

}
