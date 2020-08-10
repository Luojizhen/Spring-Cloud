package cn.tedu.rs.m2;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author lJZ
 * @date   2020-08-08
 * Queue : 是队列的封装对象,它封装了队列的参数信息.
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    /**
     * 创建持久队列
     */
    @Bean
    public Queue task_queue(){
        // 这个构造方法创建的队列参数为: 持久,非独占,不自动删除.
        return new Queue("task_queue",true);
    }
}
