package cn.tedu.rs.m5;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * @author Ljz
 * @date   2020-08-10
 */
@Component
public class Producer {

    @Autowired
    AmqpTemplate amqpTemplate;

    public void send(){
        while(true){
            System.out.print("输入消息:");
            String s = new Scanner(System.in).nextLine();
            System.out.print("输入路由键:");
            String key = new Scanner(System.in).nextLine();

            amqpTemplate.convertAndSend("topic_logs",key,s);
        }

    }

}
