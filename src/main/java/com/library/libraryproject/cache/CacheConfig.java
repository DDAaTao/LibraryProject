package com.library.libraryproject.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


/**
 * @author dcl
 * @since 2018年10月24日00:14:11
 *
 * 引入Caffeine本地缓存，可以避免高并发情况下对数据库的多次查询（针对相对稳定不变的表，如config表）
 * */

@Configuration
@EnableCaching
public class CacheConfig {

    private static final int DEFAULT_MAXSIZE = 100;
    private static final int DEFAULT_TTL = 600;

    /**
     * 此枚举类即为需要添加缓存的对应的value
     * */
    public enum Caches {
        /**
         * 有效期，最大数量
         * */
        config(86400,100),
        allRegion(600, 10);



        private int ttl = DEFAULT_TTL;
        private int maxSize = DEFAULT_MAXSIZE;

        Caches(int ttl, int maxSize) {
            this.ttl = ttl;
            this.maxSize = maxSize;
        }

        public int getTtl() {
            return ttl;
        }

        public int getMaxSize() {
            return maxSize;
        }

    }

    /**
     * 创建基于Caffeine的Cache Manager
     * */
    @Bean
    @Primary
    public CacheManager caffeineCacheManager(){
        SimpleCacheManager manager = new SimpleCacheManager();
        ArrayList<CaffeineCache> caches = new ArrayList<>();
        for (Caches c : Caches.values()){
            caches.add(new CaffeineCache(c.name(),
                    Caffeine.newBuilder().recordStats()
                            .expireAfterWrite(c.getTtl(), TimeUnit.SECONDS)
                            .maximumSize(c.getMaxSize())
                            .build()));
        }
        manager.setCaches(caches);
        return manager;
    }
}
