package cn.tedu.rs.m5;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Ljz
 * @date   2020-08-10
 */
@Component
public class Consumer {

    @RabbitListener(bindings = @QueueBinding(value = @Queue,exchange = @Exchange(name = "topic_logs", declare = "false"),key = {"*.orange.*"}))
    public void receive1(String s) throws Exception {
        System.out.println("receiver1 - 收到: "+s);
    }
    @RabbitListener(bindings = @QueueBinding(value = @Queue, exchange = @Exchange(name = "topic_logs", declare = "false"),key = {"*.*.rabbit","lazy.#"}))
    public void receive2(String s) throws Exception {
        System.out.println("receiver2 - 收到: "+s);
    }

}
