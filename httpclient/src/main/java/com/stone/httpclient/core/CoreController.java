package com.stone.httpclient.core;

import com.stone.httpclient.config.WXConfig;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
public class CoreController {

    private WXConfig wxConfig;

    @Resource(name = "httpClientFactoryBean")
    private CloseableHttpClient client;

    @Autowired
    public void setWxConfig(WXConfig wxConfig) {
        this.wxConfig = wxConfig;
    }

    @CrossOrigin
    @GetMapping("/")
    public ResponseEntity<String> index(@RequestParam("echostr") String echostr) {
        return ResponseEntity.ok(echostr);
    }

    @GetMapping("/getAccessToken")
    public ResponseEntity<String> getAccessToken() {
        HttpEntity entity = null;
        String json = "";
        HttpGet httpGet = new HttpGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + wxConfig.getAppID() + "&secret=" + wxConfig.getAppSecret());
        try {
            CloseableHttpResponse response = client.execute(httpGet);
            entity = response.getEntity();
            json = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != entity) {
                EntityUtils.consumeQuietly(entity);
            }
        }
        return ResponseEntity.ok(json);
    }

}
