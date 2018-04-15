package com.stone.box.config;

import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;

import java.util.concurrent.TimeUnit;

/**
 * HttpClient配置
 */
public class HttpClientConfig {
    /**
     * 连接池最大连接数
     */
    private int connMaxTotal;
    /**
     * 路由 1个路由和最大连接数一样
     */
    private int maxPerRoute;
    /**
     * 连接存活时间，单位s
     */
    private int timeToLive;
    /**
     * 长连接保持时间，单位为s
     */
    private int keepAliveTime;
    /**
     * 连接超时时间，单位ms
     */
    private int connectTimeout;
    /**
     * 请求超时时间
     */
    private int connectRequestTimeout;
    /**
     * sock超时时间
     */
    private int socketTimeout;

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

    /**
     * 连接池管理
     */
    public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager() {
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(this.timeToLive, TimeUnit.SECONDS);
        poolingHttpClientConnectionManager.setMaxTotal(this.connMaxTotal);
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(this.maxPerRoute);
        return poolingHttpClientConnectionManager;
    }

    /**
     * 连接保持策略
     */
    public ConnectionKeepAliveStrategy connectionKeepAliveStrategy() {
        return (response, context) -> {
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
            return this.keepAliveTime * 1000;
        };
    }

    /**
     * 用来设置请求的各种配置
     */
    public RequestConfig config() {
        return RequestConfig.custom()
                .setConnectionRequestTimeout(this.connectRequestTimeout)
                .setConnectTimeout(this.connectTimeout)
                .setSocketTimeout(this.socketTimeout)
                .build();
    }

}
