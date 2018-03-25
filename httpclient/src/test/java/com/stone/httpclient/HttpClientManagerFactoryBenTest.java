package com.stone.httpclient;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpClientManagerFactoryBenTest {
    // 注入HttpClient实例
    @Resource(name = "httpClientFactoryBean")
    private CloseableHttpClient client;

    @Test
    public void test() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            service.submit(() -> {
                System.out.println("the current thread is:" + Thread.currentThread().getName());
                HttpEntity entity = null;
                try {
                    HttpGet get = new HttpGet("http://love5t.cn");
                    CloseableHttpResponse response = client.execute(get);
                    System.out.println("client object:" + client);
                    entity = response.getEntity();
                    System.out.println("============" + EntityUtils.toString(entity, Consts.UTF_8) + "=============");
                    EntityUtils.consumeQuietly(entity);// 释放连接
                } catch (ParseException | IOException e) {
                    e.printStackTrace();
                } finally {
                    if (null != entity) {// 释放连接
                        EntityUtils.consumeQuietly(entity);
                    }
                }
            });
        }
        Thread.sleep(60000);
    }
}  