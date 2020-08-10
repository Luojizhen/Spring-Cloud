package rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
//Rabbitmq 简单模式
/**
 * @author : Ljz
 * @Date   : 2020-08-03
 * Rabbitmq 测试类1 : 模拟生产者发送消息
 */
public class Test1 {

    public static void main(String[] args) throws Exception {
        //创建连接工厂,并设置连接信息
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

        //定义队列,会通知服务器想使用一个 "Helloworld" 队列,
        //服务器会找到这个队列，如果不存在，服务器会新建队列
        /**
         * 参数含义 : 1.队列名, 2.是否持久化队列, 3.是否排他(独占)队列, 4.是否自动删除, 5.其他参数属性.
         */
        channel.queueDeclare("Helloworld",false,false,false,null);


        /**
         * 发布消息
         * 参数含义: 1.空串, 2.队列名, 3.
         *第一个参数 是 默认的交换机 direct, 默认是"".
         */
        channel.basicPublish("","Helloworld",null,"Hello啊 老马~".getBytes());

        System.out.println("消息已发送");
        //关闭通道
        c.close();
    }
}
