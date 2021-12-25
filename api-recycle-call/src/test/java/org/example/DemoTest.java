package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.client.MyClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
//https://blog.csdn.net/qq_38225558/article/details/108258130
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest {

    @Autowired
    private MyClient myClient;

    @Test
    public void testForest() throws Exception {
        // 调用接口
/*        String index = myClient.index();
        log.info("index: 【{}】", index);

        String hello = myClient.hello("测试...");
        log.info("hello: 【{}】", hello);*/

        Map location = myClient.getLocation("121.475078", "31.223577");
        log.info("location: 【{}】", location.toString());

        Object o = myClient.httpsTest();
        log.info("httpsTest: 【{}】", o.toString());
    }
}
