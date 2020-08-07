package cn.tedu.sp11;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Ljz
 * @Date   2020-08-05
 */

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class Sp11ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sp11ZuulApplication.class, args);
    }

}
