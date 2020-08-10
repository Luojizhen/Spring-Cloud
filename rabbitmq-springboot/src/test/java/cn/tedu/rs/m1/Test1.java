package cn.tedu.rs.m1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

@SpringBootTest
public class Test1 {

    @Autowired
    Producer producer;

    @Test
    public void test1(){
        producer.send();
        System.out.println("按回车结束!");
        new Scanner(System.in).nextLine();
    }

}
