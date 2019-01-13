package com.redisson.config;

import io.netty.channel.nio.NioEventLoopGroup;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    private static final String IP = "192.168.0.108:6379";

    @Bean
    public RedissonClient redissonClient(){
        Config config = new Config();
        config.setThreads(3);
        config.setNettyThreads(3);
        config.setEventLoopGroup(new NioEventLoopGroup());

        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress("redis://"+IP)
                .setConnectionMinimumIdleSize(10)
                .setConnectionPoolSize(64)
                .setTimeout(5000)
                .setDnsMonitoringInterval(5000)
                .setDatabase(0)
                .setConnectTimeout(10000)
                .setIdleConnectionTimeout(10000)
                .setRetryAttempts(3)
                .setRetryInterval(1500)
                .setPingTimeout(1000);

        return Redisson.create(config);
    }

}
