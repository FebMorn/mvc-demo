package com.sl.basic.web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 扩展AbstractAnnotationConfigDispatcherServletInitializer的任意类都会自动地配置DispatcherServlet和Spring的应用上下文
 */
public class BasicWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    /**
     * 指定servlet配置类
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{BaseWebConfig.class};
    }

    /**
     * 将一个或多个路径映射到DispatcherServlet上
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
