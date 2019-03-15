package com.jay.guava.cache;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName GuavaProperties
 * @Description Guava缓存配置参数
 * @Date 2019/3/15
 * @Author lufangjie
 * @Version 1.0
 **/
@ConfigurationProperties(prefix = "guava.cache.config")
public class GuavaProperties {

    private long maximumSize;
    private long maximumWeight;

    public long getMaximumSize() {
        return maximumSize;
    }

    public void setMaximumSize(long maximumSize) {
        this.maximumSize = maximumSize;
    }

    public long getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(long maximumWeight) {
        this.maximumWeight = maximumWeight;
    }
}
