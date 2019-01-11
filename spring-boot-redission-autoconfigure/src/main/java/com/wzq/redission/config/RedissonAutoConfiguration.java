package com.wzq.redission.config;

import io.netty.channel.nio.NioEventLoopGroup;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SentinelServersConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass({RedissonClient.class})
@EnableConfigurationProperties({RedissonProperties.class})
public class RedissonAutoConfiguration {

    @Autowired
    RedissonProperties redissonProperties;

    @Bean
    public RedissonClient redissonClient(){
        Config config = new Config();
        config.setThreads(redissonProperties.getThread());
        config.setNettyThreads(redissonProperties.getThread());
        config.setEventLoopGroup(new NioEventLoopGroup());
        SentinelServersConfig sentinelServersConfig = config.useSentinelServers();
        sentinelServersConfig.setDatabase(redissonProperties.getDatabase());

        if(redissonProperties.getMasterName() != null){
            sentinelServersConfig.setMasterName(redissonProperties.getMasterName());
        }

        sentinelServersConfig.setMasterConnectionMinimumIdleSize(redissonProperties.getConnectionMinimumIdleSize())
                        .setMasterConnectionPoolSize(redissonProperties.getConnectionPoolSize())
                        .setSlaveConnectionMinimumIdleSize(redissonProperties.getConnectionMinimumIdleSize())
                        .setSlaveConnectionPoolSize(redissonProperties.getConnectionPoolSize())
                        .setDnsMonitoringInterval(redissonProperties.getDnsMonitoringInterval())
                        .setFailedAttempts(redissonProperties.getFailedAttempts())
                        .setRetryAttempts(redissonProperties.getRetryAttempts())
                        .setRetryInterval(redissonProperties.getRetryInterval())
                        .setReconnectionTimeout(redissonProperties.getReconnectionTimeout())
                        .setTimeout(redissonProperties.getTimeout())
                        .setConnectTimeout(redissonProperties.getConnectTimeout())
                        .setIdleConnectionTimeout(redissonProperties.getIdleConnectionTimeout())
                        .setPingTimeout(redissonProperties.getPingTimeout());

        if(redissonProperties.getPassword() != null){
            sentinelServersConfig.setPassword(redissonProperties.getPassword());
        }

        String[] hosts = redissonProperties.getHosts().split(",");

        for(String ip : hosts){
            sentinelServersConfig.addSentinelAddress("redis://"+ip);
        }


        return Redisson.create(config);
    }


}