package cn.tedu.rs.m3;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Ljz
 * @date   020-08-10
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    /**
     * 创建 FanoutExchange 实例, 封装 fanout 类型交换机定义信息.
     * spring boot 的自动配置类会自动发现交换机实例, 并在 RabbitMQ 服务器中定义该交换机.
     * @return
     */
    @Bean
    public FanoutExchange logsExchange(){
        return new FanoutExchange("logs");
    }

}
