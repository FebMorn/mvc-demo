package com.sl.core.context.cache.redis;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

public class RedisKeyGenerator implements KeyGenerator {

    public Object generate(Object target, Method method, Object... params) {
        return generateKey(target,method,params);
    }

    public static Object generateKey(Object target, Method method, Object... params) {
        StringBuilder key = new StringBuilder();
        key.append(target.getClass().getName());
        key.append("-");
        key.append(method.getName());
        key.append("-[");
        if (params.length > 0) {
            key.append(StringUtils.arrayToCommaDelimitedString(params));
        }
        key.append("]");
        return key.toString();
    }

    public RedisKeyGenerator() {}

}
