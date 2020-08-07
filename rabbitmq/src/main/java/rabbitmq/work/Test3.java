package rabbitmq.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;


/**
 * Rabbitmq工作模式 (提供者)
 * @author : Ljz
 * @Date   : 2020-08-04
 */
public class Test3 {

    public static void main(String[] args) throws IOException, TimeoutException {

        //创建建立连接的信息
        ConnectionFactory f = new ConnectionFactory();
        f.setHost("192.168.126.128");
        f.setPort(5672);  //默认通信端口
        f.setUsername("MiChaelJordan");
        f.setPassword("666666");

        //与rabbitmq服务器建立连接
        Connection c = f.newConnection();
        //与rabbitmq服务器建立通信通道
        Channel ch = c.createChannel();

        //定义队列, 并将第二个参数设置为true,消息持久化
        ch.queueDeclare("MiChaelJordan",true,false,false,null);

        while(true){
            System.out.println("输入消息 :");
            String msg = new Scanner(System.in).nextLine();
            if ("exit".equals(msg)){
                break;
            }

            //发送消息 , 并将第三个参数设置消息持久化
            ch.basicPublish("","MiChaelJordan", MessageProperties.PERSISTENT_TEXT_PLAIN,msg.getBytes("UTF-8"));
            System.out.println("消息已发送: "+msg);
        }

        c.close();

    }


}
