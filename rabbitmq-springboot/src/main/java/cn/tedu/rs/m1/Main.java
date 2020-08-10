package cn.tedu.rs.m1;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


/**
 * @author lJZ
 * @date   2020-08-08
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    @Bean
    public Queue hellworldQueue(){
        //持久的
        //return new Queue("hellworld");
        //非持久的
        return new Queue("Helloworld",false);
    }

}
