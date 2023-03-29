package com.newsData.newsDataAPI.config;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.slf4j.Logger;

import java.io.IOException;


@Configuration
@EnableCaching
public class EhcacheConfig {

    static Logger log= LoggerFactory.getLogger(EhcacheConfig.class);

    @Bean(name="cacheManager")
    CacheManager cacheManager() throws IOException {
        return new EhCacheCacheManager(ehCacheManager());
    }


    private net.sf.ehcache.CacheManager ehCacheManager( ) throws IOException {
       log.info("Initializing the cache manager");
        EhCacheManagerFactoryBean factoryBean= new EhCacheManagerFactoryBean();
        factoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        factoryBean.setShared(true);
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

}
