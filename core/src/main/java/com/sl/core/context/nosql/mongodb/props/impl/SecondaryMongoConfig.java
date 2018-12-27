package com.sl.core.context.nosql.mongodb.props.impl;

import com.sl.core.context.nosql.mongodb.props.BaseMongoConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

public class SecondaryMongoConfig extends BaseMongoConfig {
    @Override
    public @Bean(name = "secondaryMongoTemplate") MongoTemplate getMongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }
}
