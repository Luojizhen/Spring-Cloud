package cn.tedu.rs.m4;

import org.springframework.amqp.core.DirectExchange;
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

    @Bean
    public DirectExchange fanoutExchange(){
        return new DirectExchange("direct_logs");
    }

}
