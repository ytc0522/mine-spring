package org.example.mine.spring.beans.factory.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 作者 xinyi
 * 日期 2022/5/4 2:40 PM
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    /**
     * 用来存放Bean对象的容器
     */
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    @Override
    public void registerSingleton(String beanName, Object singleObject) {
        singletonObjects.put(beanName, singleObject);
    }

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }
}
