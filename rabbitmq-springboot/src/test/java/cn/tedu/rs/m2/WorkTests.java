package cn.tedu.rs.m2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

@SpringBootTest
public class WorkTests {
    @Autowired
    private Producer workSender;

    @Test
    public void test1() {
        workSender.send();
        new Scanner(System.in).nextLine();
    }
}