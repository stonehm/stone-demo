package com.stone.box.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {

    private final static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    private final CloseableHttpClient httpClient;

    public HttpClientUtil(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String post(String url, Map<String, String> parameters) {
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList<>();
        parameters.forEach((key, value) -> nvps.add(new BasicNameValuePair(key, value)));
        nvps.add(new BasicNameValuePair("timestamp", TimeUtil.getTimestamp()));
        httpPost.setEntity(EntityBuilder.create().setParameters(nvps).build());
        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            response.close();
            return result;
        } catch (IOException e) {
            logger.error("post error:" + e.getMessage());
        }
        return null;
    }
}
