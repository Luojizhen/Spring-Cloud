package cn.tedu.rs.m2;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * @author lJZ
 * @date   2020-08-08
 * AmqpTemplate : 是rabbitmq客户端API的一个封装工具,提供了简便的方法来执行消息操作.
 */
@Component
public class Producer {

    @Autowired
    AmqpTemplate amqpTemplate;

    public void send(){

            System.out.println("输入: ");
            String msg = new Scanner(System.in).nextLine();
            amqpTemplate.convertAndSend("task_queue", msg);

    }

}
