package com.stone.box;

import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BoxApplicationTests {

    @Autowired
    CloseableHttpClient httpClient;

    @Test
    public void contextLoads() {
        System.out.println(httpClient.getClass());

    }

}
