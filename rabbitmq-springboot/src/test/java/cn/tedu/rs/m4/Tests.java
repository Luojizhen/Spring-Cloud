package cn.tedu.rs.m4;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Tests {

    @Autowired
    Producer producer;

    @Test
    public void test()throws Exception{
        producer.send();
    }

}
