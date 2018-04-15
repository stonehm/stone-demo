package com.stone.box;

import com.stone.box.util.TimeUtil;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class Test {
//    private static Logger logger = LoggerFactory.getLogger(Test.class);
//
//    @Autowired
//    private CloseableHttpClient httpClient;
//
//    @org.junit.Test
//    public void spots() throws IOException {
//        HttpPost httpPost = new HttpPost("http://api.irichi.cn:8348/screenlock/map/spots");
//
//        List<NameValuePair> nvps = new ArrayList<>();
//        nvps.add(new BasicNameValuePair("appId", "yuYsd0cOYKyWGbRO"));
//        nvps.add(new BasicNameValuePair("mapId", "2"));
//        nvps.add(new BasicNameValuePair("timestamp", TimeUtil.getTimestamp()));
//        httpPost.setEntity(EntityBuilder.create().setParameters(nvps).build());
//        CloseableHttpResponse response1 = httpClient.execute(httpPost);
//        HttpEntity entity2 = response1.getEntity();
//        String result = EntityUtils.toString(entity2);
//        logger.info("get box:" + result);
//        response1.close();
//    }
//
//    @org.junit.Test
//    public void flow() throws IOException {
//        HttpPost httpPost = new HttpPost("http://api.irichi.cn:8348/screenlock/map/award");
//
//        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//        nvps.add(new BasicNameValuePair("appId", "AysG55kMICs6ZQx6"));
//        nvps.add(new BasicNameValuePair("mapId", "1"));
//        nvps.add(new BasicNameValuePair("spotId", "22"));
//        nvps.add(new BasicNameValuePair("timestamp", TimeUtil.getTimestamp()));
//        httpPost.setEntity(EntityBuilder.create().setParameters(nvps).build());
//        CloseableHttpResponse response1 = httpClient.execute(httpPost);
//        HttpEntity entity2 = response1.getEntity();
//        String result = EntityUtils.toString(entity2);
//        logger.info("get box:" + result);
//        response1.close();
//    }
}
