package rabbitmq.publishsubscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @author Ljz
 * @Date   2020-08-05
 */
public class Test1 {

    public static void main(String[] args) throws IOException, TimeoutException {

        //设置连接信息
        ConnectionFactory f = new ConnectionFactory();
        f.setHost("192.168.126.128");
        //5672是默认通信端口
        f.setPort(5672);
        f.setUsername("MiChaelJordan");
        f.setPassword("666666");

        //与rabbit服务器建立连接
        Connection c = f.newConnection();
        //与rabbit服务器建立通信通道
        Channel channel = c.createChannel();

        //定义名字为logs的交换机,交换机类型为fanout
        //这一步是必须的，因为禁止发布到不存在的交换。
        channel.exchangeDeclare("logs","fanout");

        while (true) {
            System.out.print("输入消息: ");
            String msg = new Scanner(System.in).nextLine();
            if ("exit".equals(msg)) {
                break;
            }

            //第一个参数,向指定的交换机发送消息
            //第二个参数,不指定队列,由消费者向交换机绑定队列
            //如果还没有队列绑定到交换器，消息就会丢失，
            //但这对我们来说没有问题;即使没有消费者接收，我们也可以安全地丢弃这些信息。
            channel.basicPublish("logs", "", null, msg.getBytes("UTF-8"));
            System.out.println("消息已发送: "+msg);
        }

        c.close();
    }
}
