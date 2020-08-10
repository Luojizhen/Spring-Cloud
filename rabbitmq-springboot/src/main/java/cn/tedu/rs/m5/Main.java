package cn.tedu.rs.m5;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Ljz
 * @date   2020-08-10
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    @Bean
    public TopicExchange fanoutExchange(){
        return new TopicExchange("topic_logs");
    }
}
