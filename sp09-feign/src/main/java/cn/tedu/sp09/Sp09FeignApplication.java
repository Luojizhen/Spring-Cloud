package cn.tedu.sp09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients      //开启Feign客户端 告诉框架扫描所有使用@FeignClient注解定义的客户端!
@EnableDiscoveryClient   //注册到Eureka
@EnableCircuitBreaker    //Hystrix断路器注解
public class Sp09FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sp09FeignApplication.class, args);
    }

}
