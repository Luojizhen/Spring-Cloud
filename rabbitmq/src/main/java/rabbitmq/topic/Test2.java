package rabbitmq.topic;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

/**
 * @author Ljz
 * @date   2020-08-09
 */
public class Test2 {

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

        //定义交换机, 定义随机队列,用绑定键绑定
        ch.exchangeDeclare("topic_logs", BuiltinExchangeType.TOPIC);
        String queue = UUID.randomUUID().toString();
        ch.queueDeclare(queue,false,true,true,null);
        System.out.println("输入绑定键,用空格隔开: ");
        String s = new Scanner(System.in).nextLine();
        //正则表达式 : 一到多个的空白字符进行拆分.
        String[] keys = s.split("\\s+");
        for (String key : keys) {
            ch.queueBind(queue,"topic_logs",key);
        }

        DeliverCallback callback = new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) throws IOException {
                String msg = new String(message.getBody());
                String key = message.getEnvelope().getRoutingKey();
                System.out.println(key+" - "+msg);
            }
        };

        CancelCallback cancel = new CancelCallback() {
            @Override
            public void handle(String consumerTag) throws IOException {

            }
        };

        //消费数据
        ch.basicConsume(queue,true,callback,cancel);
    }

}
