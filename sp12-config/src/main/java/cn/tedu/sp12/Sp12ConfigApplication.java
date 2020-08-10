package cn.tedu.sp12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Ljz
 * @Date   2020-08-07
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class Sp12ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sp12ConfigApplication.class, args);
    }

}
