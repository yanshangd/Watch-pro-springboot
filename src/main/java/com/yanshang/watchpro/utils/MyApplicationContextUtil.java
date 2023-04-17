package com.yanshang.watchpro.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationContextUtil implements ApplicationContextAware {
    /**
     * 当前IOC
     *
     */
    private static ApplicationContext applicationContext;

    /**
     * 设置applicationContext
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        MyApplicationContextUtil.applicationContext = applicationContext;
    }


    public static String[] getBeanNamesForType(Class<?> clazz ){
        return applicationContext.getBeanNamesForType(clazz);
    }

    public static <T> T getBean(String beanName,Class<T> clazz) {
        return applicationContext.getBean(beanName,clazz);
    }

    public static  <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }
}
