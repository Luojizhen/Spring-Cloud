package rabbitmq.routing;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.sun.xml.internal.ws.util.StringUtils;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @author Ljz
 * @Date   2020-08-08
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

        //定义 direct 类型交换机: direct_logs
        ch.exchangeDeclare("direct_logs", BuiltinExchangeType.DIRECT);

        //发送消息,在消息上携带路由键关键词
        while(true){
            System.out.println("输入消息:  ");
            String msg = new Scanner(System.in).nextLine();
            if("exit".equals(msg)){
                break;
            }
            System.out.println("输入路由键:  ");
            String key = new Scanner(System.in).nextLine();

            //发送消息, 第二个参数是路由键,通过键的匹配确定向哪个队列发送
            ch.basicPublish("direct_logs",key,null,msg.getBytes());
        }
        c.close();
    }

}
