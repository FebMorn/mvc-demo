package com.sl.core.context.nosql.mongodb.props.impl;

import com.sl.core.context.nosql.mongodb.props.BaseMongoConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * 默认的mongodb配置
 */
public class PrimaryMongoConfig extends BaseMongoConfig {
    @Primary
    @Override
    public @Bean(name = "primaryMongoTemplate") MongoTemplate getMongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }
}
