package com.wradwanski.repository.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
@Profile("!integration-test")
class CacheConfiguration {

    @Bean
    CaffeineCache fulfillmentCenterConfiguration() {
        return new CaffeineCache("githubClient", Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.DAYS).build());
    }

}
