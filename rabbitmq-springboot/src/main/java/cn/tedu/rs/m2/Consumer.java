package cn.tedu.rs.m2;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Ljz
 * @date   2020-08-09
 * @RabbitListener : 指定的队列接收消息.
 */
@Component
public class Consumer {

    @RabbitListener(queues = "task_queue")
    public void receiver1(String msg) throws InterruptedException {
        System.out.println("receiver1 - 收到: "+msg);
        for (int i=0; i<msg.length();i++){
            if (msg.charAt(i)=='.'){
                Thread.sleep(1000);
            }
        }
        System.out.println("消费者1 - 消息处理完成");
    }

    @RabbitListener(queues = "task_queue")
    public void receiver2(String msg) throws InterruptedException {
        System.out.println("receiver2 - 收到: "+msg);
        for (int i=0; i<msg.length();i++){
            if (msg.charAt(i)=='.'){
                Thread.sleep(1000);
            }
        }
        System.out.println("消费者2 - 消息处理完成");
    }

}
