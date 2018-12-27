package com.sl.core.context.cache.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 * <p>redis缓存配置</p>
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport{

    private static final Long CACHE_TIME_DEFAULT = 3600L;

    /**
     * 重写默认的key生成方法
     * @return KeyGenerator
     */
    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return new RedisKeyGenerator();
    }

    /**
     * springboot2.x中RedisCacheManager没有了RedisTemplate传参的构造方法了
     * @param factory
     * @return
     */
    //TODO 作用 和 生效机制
    @Bean
    @Primary
    public CacheManager cacheManager(RedisConnectionFactory factory) {

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        /*
        默认配置
        duration : Duration.ZERO
        cacheNullValues : true
        usePrefix : true
        cacheKeyPrefix : CacheKeyPrefix.simple()
         */
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
        /*
        entryTtl : 定义默认的cache time-to-live
        disableCachingNullValues : 禁止缓存Null对象. 这个识需求而定
        computePrefixWith : 此处定义了cache key的前缀, 避免公司不同项目之间的key名称冲突
        serializeKeysWith : 定义key的序列化协议，同时hash key也被定义
        serializeValuesWith : 定义value的序列化协议，同时hash value也被定义
         */
        config.entryTtl(Duration.ofSeconds(CACHE_TIME_DEFAULT));
        config.disableCachingNullValues();
        //config.computePrefixWith(CacheKeyPrefix.simple());
        //TODO 这个lambda是什么意思?
        config.computePrefixWith(cacheName -> "demo".concat(":").concat(cacheName).concat(":"));
        //TODO 下面两个序列化的含义
        config.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()));
        config.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer));


        return RedisCacheManager.builder(factory)
                .cacheDefaults(config)
                .build();
    }


    //TODO 作用 和 生效机制
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory){
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(jackson2JsonRedisSerializer);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashKeySerializer(jackson2JsonRedisSerializer);
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
        //RedisSentinelConfiguration redisSentinelConfiguration = new RedisSentinelConfiguration();
        //redisSentinelConfiguration.sentinel("127.0.0.1",6379);
        //redisSentinelConfiguration.setDatabase(0);
        //redisSentinelConfiguration.setPassword(RedisPassword.none());
        //
        //JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //jedisPoolConfig.setMinIdle(0);
        //jedisPoolConfig.setMaxIdle(9);
        //jedisPoolConfig.setMaxWaitMillis(-1);
        //jedisPoolConfig.setBlockWhenExhausted(true);
        //jedisPoolConfig.setTestOnBorrow(true);
        //
        //return new JedisConnectionFactory(redisSentinelConfiguration,jedisPoolConfig);
    }

}
