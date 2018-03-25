package com.stone.httpclient.config;

import org.apache.http.*;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

@Configuration
public class HttpClientConfig {

    private int retryTime;
    private int connMaxTotal;
    private int maxPerRoute;
    private int timeToLive;
    private int keepAliveTime;
    private boolean enableProxy;
    private String proxyHost;
    private int proxyPort;
    private int connectTimeout;
    private int connectRequestTimeout;
    private int socketTimeout;

    /**
     * HttpClient的重试处理机制
     */
    @Bean
    public HttpRequestRetryHandler httpRequestRetryHandler() {
        // 请求重试
        final int retryTime = this.retryTime;
        return (exception, executionCount, context) -> {
            // Do not retry if over max retry count,如果重试次数超过了retryTime,则不再重试请求
            if (executionCount >= retryTime) {
                return false;
            }
            // 服务端断掉客户端的连接异常
            if (exception instanceof NoHttpResponseException) {
                return true;
            }
            // time out 超时重试
            if (exception instanceof InterruptedIOException) {
                return true;
            }
            // Unknown host
            if (exception instanceof UnknownHostException) {
                return false;
            }
            // Connection refused
            if (exception instanceof ConnectTimeoutException) {
                return false;
            }
            // SSL handshake exception
            if (exception instanceof SSLException) {
                return false;
            }
            HttpClientContext clientContext = HttpClientContext.adapt(context);
            HttpRequest request = clientContext.getRequest();
            return !(request instanceof HttpEntityEnclosingRequest);
        };
    }

    /**
     * 连接池管理
     */
    @Bean
    public PoolingHttpClientConnectionManager poolingClientConnectionManager() {
        PoolingHttpClientConnectionManager poolHttpcConnManager = new PoolingHttpClientConnectionManager(this.timeToLive, TimeUnit.SECONDS);
        // 最大连接数
        poolHttpcConnManager.setMaxTotal(this.connMaxTotal);
        // 路由基数
        poolHttpcConnManager.setDefaultMaxPerRoute(this.maxPerRoute);
        return poolHttpcConnManager;
    }

    /**
     * 连接保持策略
     */
    @Bean("connectionKeepAliveStrategy")
    public ConnectionKeepAliveStrategy connectionKeepAliveStrategy() {
        return (response, context) -> {
            // Honor 'keep-alive' header
            HeaderElementIterator it = new BasicHeaderElementIterator(response.headerIterator(HTTP.CONN_KEEP_ALIVE));
            while (it.hasNext()) {
                HeaderElement he = it.nextElement();
                String param = he.getName();
                String value = he.getValue();
                if (value != null && param.equalsIgnoreCase("timeout")) {
                    try {
                        return Long.parseLong(value) * 1000;
                    } catch (NumberFormatException ignore) {
                    }
                }
            }
            return keepAliveTime * 1000;
        };
    }

    /**
     * 代理配置
     */
    @Bean
    public DefaultProxyRoutePlanner defaultProxyRoutePlanner() {
        if (!enableProxy) return null;
        HttpHost proxy = new HttpHost(this.proxyHost, this.proxyPort);
        return new DefaultProxyRoutePlanner(proxy);
    }

    /**
     * 用来设置请求的各种配置
     */
    @Bean
    public RequestConfig config() {
        return RequestConfig.custom()
                .setConnectionRequestTimeout(this.connectRequestTimeout)
                .setConnectTimeout(this.connectTimeout)
                .setSocketTimeout(this.socketTimeout)
                .build();
    }

    public int getRetryTime() {
        return retryTime;
    }

    public void setRetryTime(int retryTime) {
        this.retryTime = retryTime;
    }

    public int getConnMaxTotal() {
        return connMaxTotal;
    }

    public void setConnMaxTotal(int connMaxTotal) {
        this.connMaxTotal = connMaxTotal;
    }

    public int getMaxPerRoute() {
        return maxPerRoute;
    }

    public void setMaxPerRoute(int maxPerRoute) {
        this.maxPerRoute = maxPerRoute;
    }

    public int getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public int getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(int keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public boolean isEnableProxy() {
        return enableProxy;
    }

    public void setEnableProxy(boolean enableProxy) {
        this.enableProxy = enableProxy;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getConnectRequestTimeout() {
        return connectRequestTimeout;
    }

    public void setConnectRequestTimeout(int connectRequestTimeout) {
        this.connectRequestTimeout = connectRequestTimeout;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }
}
