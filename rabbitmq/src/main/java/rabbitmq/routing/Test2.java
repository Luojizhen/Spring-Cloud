package rabbitmq.routing;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @author Ljz
 * @Date   2020-08-08
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

        //定义 direct 类型交换机: direct_logs
        ch.exchangeDeclare("direct_logs", BuiltinExchangeType.DIRECT);

        //自动生成队列名, 非持久,独占,自动删除
        String queue = ch.queueDeclare().getQueue();
        System.out.println("输入接收的日志级别,用空格隔开:");
        //\\s+ : 正则表达式 接受多个空格
        String[] a = new Scanner(System.in).nextLine().split("\\s+");

        //把该队列,绑定到 direct_logs 交换机
        //允许使用多个 bindingKey
        for (String level : a) {
            ch.queueBind(queue, "direct_logs", level);
        }

        System.out.println("等待接收数据");

        //收到消息后用来处理消息的回调对象
        DeliverCallback callback = new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) throws IOException {
                String msg = new String(message.getBody(), "UTF-8");
                String routingKey = message.getEnvelope().getRoutingKey();
                System.out.println("收到: "+routingKey+" - "+msg);
            }
        };

        //消费者取消时的回调对象
        CancelCallback cancel = new CancelCallback() {
            @Override
            public void handle(String consumerTag) throws IOException {
            }
        };

        ch.basicConsume(queue, true, callback, cancel);
    }

}
