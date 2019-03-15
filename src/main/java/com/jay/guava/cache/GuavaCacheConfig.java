package com.jay.guava.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * @ClassName GuavaCacheConfig
 * @Description TODO
 * @Date 2019/3/15
 * @Author lufangjie
 * @Version 1.0
 **/
@EnableConfigurationProperties(GuavaProperties.class)
@EnableCaching
@Configuration
public class GuavaCacheConfig {

    @Autowired
    GuavaProperties properties;

    @Bean("caffeine")
    public Caffeine<Object, Object> getCaffeine() {
        return Caffeine.newBuilder()
                // maximumSize和maximumWeight只能同时设置一个
//                .maximumSize(properties.getMaximumSize())
                .maximumWeight(properties.getMaximumWeight());
    }

    @DependsOn({"caffeine"})
    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCaffeine(getCaffeine());
        return caffeineCacheManager;
    }
}
