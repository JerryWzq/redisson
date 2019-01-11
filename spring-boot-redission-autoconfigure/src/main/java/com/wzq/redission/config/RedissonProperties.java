package com.wzq.redission.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(
        prefix = "spring.redisson"
)
public class RedissonProperties {

    private String prefix;

    /**
     * redis地址
     */
    private String hosts = "localhost";
    /**
     * redis密码
     */
    private String password;
    /**
     * 最大空闲连接数
     */
    private int connectionPoolSize = 64;
    /**
     * 最小空闲连接数
     */
    private int connectionMinimumIdleSize = 10;
    /**
     * 当前数据库
     */
    private int database=0;
    /**
     * DNS监测时间间隔，单位：毫秒
     */
    private long dnsMonitoringInterval = 5000;
    /**
     * redis链接超时时间
     */
    private int timeout = 3000;
    /**
     * master名称
     */
    private String masterName;
    /**
     * 空闲的连接超时时间 毫秒
     */
    private int idleConnectionTimeout = 10000;
    /***
     * ping 超时时间 毫秒
     */
    private int pingTimeout = 1000;
    /**
     * 连接超时时间
     */
    private int connectTimeout = 10000;
    /**
     * 命令失败重试次数
     */
    private int retryAttempts = 3;
    /**
     * 命令重试发送时间间隔，单位：毫秒
     */
    private int retryInterval = 1500;
    /**
     * 重新连接时间间隔，单位：毫秒
     */
    private int reconnectionTimeout = 3000;
    /**
     * 执行失败最大次数
     */
    private int failedAttempts = 3;
    /**
     * 当前处理核数量 * 2
     */
    private int thread = 3;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getHosts() {
        return hosts;
    }

    public void setHosts(String hosts) {
        this.hosts = hosts;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getConnectionPoolSize() {
        return connectionPoolSize;
    }

    public void setConnectionPoolSize(int connectionPoolSize) {
        this.connectionPoolSize = connectionPoolSize;
    }

    public int getConnectionMinimumIdleSize() {
        return connectionMinimumIdleSize;
    }

    public void setConnectionMinimumIdleSize(int connectionMinimumIdleSize) {
        this.connectionMinimumIdleSize = connectionMinimumIdleSize;
    }

    public int getDatabase() {
        return database;
    }

    public void setDatabase(int database) {
        this.database = database;
    }

    public long getDnsMonitoringInterval() {
        return dnsMonitoringInterval;
    }

    public void setDnsMonitoringInterval(long dnsMonitoringInterval) {
        this.dnsMonitoringInterval = dnsMonitoringInterval;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public void setIdleConnectionTimeout(int idleConnectionTimeout) {
        this.idleConnectionTimeout = idleConnectionTimeout;
    }

    public int getIdleConnectionTimeout() {
        return idleConnectionTimeout;
    }

    public int getPingTimeout() {
        return pingTimeout;
    }

    public void setPingTimeout(int pingTimeout) {
        this.pingTimeout = pingTimeout;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getRetryAttempts() {
        return retryAttempts;
    }

    public void setRetryAttempts(int retryAttempts) {
        this.retryAttempts = retryAttempts;
    }

    public int getRetryInterval() {
        return retryInterval;
    }

    public void setRetryInterval(int retryInterval) {
        this.retryInterval = retryInterval;
    }

    public int getReconnectionTimeout() {
        return reconnectionTimeout;
    }

    public void setReconnectionTimeout(int reconnectionTimeout) {
        this.reconnectionTimeout = reconnectionTimeout;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(int failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public int getThread() {
        return thread;
    }

    public void setThread(int thread) {
        this.thread = thread;
    }
}