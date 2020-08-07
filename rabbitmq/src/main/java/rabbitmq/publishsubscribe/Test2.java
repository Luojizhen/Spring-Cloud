package rabbitmq.publishsubscribe;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Ljz
 * @Date   2020-08-05
 */
public class Test2 {

    public static void main(String[] args) throws IOException, TimeoutException {

        //设置连接信息
        ConnectionFactory f = new ConnectionFactory();
        f.setHost("192.168.126.128");
        //5672是默认通信端口
        f.setPort(5672);
        f.setUsername("MiChaelJordan");
        f.setPassword("666666");

        //与rabbit服务器建立连接及通信通道
        Channel c = f.newConnection().createChannel();

        //三个步骤 : 1.定义交换机 2.定义随机队列 3.绑定到交换机
        c.exchangeDeclare("logs", BuiltinExchangeType.FANOUT);

        //自动生成队列名
        //非持久 独占 自动删除
        String queue = c.queueDeclare().getQueue();

        //第三个参数对 fanout 交换机无效
        c.queueBind(queue,"logs","");


        //收到消息后用来处理消息的回调对象
        DeliverCallback callback = new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) throws IOException {
                String msg = new String(message.getBody(),"UTF-8");
                System.out.println("收到: "+msg);
            }
        };
        //消费者取消时的回调对象
        CancelCallback cancel = new CancelCallback() {
            @Override
            public void handle(String consumerTag) throws IOException {
            }
        };

        c.basicConsume(queue,true,callback,cancel);


    }
}
