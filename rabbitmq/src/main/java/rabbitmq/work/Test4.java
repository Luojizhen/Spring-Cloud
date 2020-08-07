package rabbitmq.work;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Rabbitmq工作模式 (消费者)
 * @author : Ljz
 * @Date   : 2020-08-04
 */
public class Test4 {

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
        System.out.println("等待接收数据");
        ch.basicQos(1); //一次只抓取一条消息(必须在手动ACK下有效);

        //收到消息后用来处理消息的回调对象
        DeliverCallback callback = new DeliverCallback() {
            @Override
            public void handle(String s, Delivery message) throws IOException {
                String msg = new String(message.getBody(),"UTF-8");
                System.out.println("收到: "+msg);
                for (int i=0; i<msg.length();i++){
                    if (msg.charAt(i)=='.'){
                        try {
                            Thread.sleep(1000);
                        }catch (InterruptedException e){
                        }
                    }
                }
                System.out.println("处理结束");
                //发送回执
                ch.basicAck(message.getEnvelope().getDeliveryTag(),false);
            }
        };

        //消费者取消时的回调对象
        CancelCallback cancel = new CancelCallback() {
            @Override
            public void handle(String consumerTag) throws IOException {
            }
        };

        //autoAck设置为false,则需要手动确认发送回执
        ch.basicConsume("MiChaelJordan", false, callback, cancel);

    }

}
