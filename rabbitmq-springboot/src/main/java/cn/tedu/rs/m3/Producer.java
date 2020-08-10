package cn.tedu.rs.m3;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * @author lJZ
 * @date   2020-08-10
 */
@Component
public class Producer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        while (true){
            System.out.println("输入: ");
            String s = new Scanner(System.in).nextLine();
            //指定向 logs 交换机发送, "",不指定队列名或路由键.
            amqpTemplate.convertAndSend("logs","",s);
        }
    }

}
