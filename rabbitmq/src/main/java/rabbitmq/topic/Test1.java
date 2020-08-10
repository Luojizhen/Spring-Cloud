package rabbitmq.topic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @author Ljz
 * @date   2020-08-09
 */
public class Test1 {

    public static void main(String[] args) throws IOException, TimeoutException {

        //创建连接工厂,并设置连接信息
        ConnectionFactory f = new ConnectionFactory();
        f.setHost("192.168.126.128");
        //5672是默认通信端口
        f.setPort(5672);
        f.setUsername("MiChaelJordan");
        f.setPassword("666666");

        Connection c = f.newConnection();
        Channel ch = c.createChannel();

        //定义交换机
        ch.exchangeDeclare("topic_logs", BuiltinExchangeType.TOPIC);

        //发送消息,携带路由键
        while (true){
            System.out.println("输入消息: ");
            String msg = new Scanner(System.in).nextLine();
            System.out.println("输入路由键: ");
            String key = new Scanner(System.in).nextLine();

            ch.basicPublish("topic_logs",key,null,msg.getBytes());
        }

    }

}
