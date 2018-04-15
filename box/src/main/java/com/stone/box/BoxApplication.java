package com.stone.box;

import com.stone.box.config.HttpClientConfig;
import com.stone.box.util.HttpClientUtil;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class BoxApplication {

    @Bean
    @ConfigurationProperties("http.config")
    public HttpClientConfig getHttpClientConfig() {
        return new HttpClientConfig();
    }

    @Bean
    public HttpClientUtil getHttpClientUtil(CloseableHttpClient httpClient) {
        return new HttpClientUtil(httpClient);
    }

    public static void main(String[] args) {
        SpringApplication.run(BoxApplication.class, args);
    }
}
