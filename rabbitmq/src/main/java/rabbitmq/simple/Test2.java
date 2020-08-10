package rabbitmq.simple;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
//Rabbitmq 简单模式
/**
 * @author : Ljz
 * @Date   : 2020-08-04
 * Rabbitmq 测试类2 : 模拟消费者接受消息
 */
public class Test2 {

    public static void main(String[] args) throws Exception {

        //创建连接工厂,并设置连接信息
        ConnectionFactory f = new ConnectionFactory();
        f.setHost("192.168.126.128");
        //5672是默认通信端口(默认端口可以省略)
        f.setPort(5672);
        f.setUsername("MiChaelJordan");
        f.setPassword("666666");

        //与rabbit服务器建立连接及通信通道
        Channel c = f.newConnection().createChannel();

        //定义队列

        c.queueDeclare("Helloworld",false,false,false,null);
        System.out.println("等待接收数据~");

        DeliverCallback callback = new DeliverCallback() {
            @Override
            public void handle(String s, Delivery message) throws IOException {
                String msg = new String(message.getBody(),"UTF-8");
                System.out.println("收到: "+msg);
            }
        };

        //消费者取消时的回调对象
        CancelCallback cancel = new CancelCallback() {
            @Override
            public void handle(String s) throws IOException {

            }
        };

        //从HelloWorld 队列接受消息, 消费消息.
        c.basicConsume("Helloworld",true,callback,cancel);

    }

}
