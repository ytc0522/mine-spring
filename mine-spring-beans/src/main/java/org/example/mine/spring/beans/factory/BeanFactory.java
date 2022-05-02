package org.example.mine.spring.beans.factory;

/**
 * Bean的工厂接口
 */
public interface BeanFactory {

    /**
     * 根据名称获取Bean对象
     */
    Object getBean(String name);

    <T> T getBean(String name, Class<T> requiredType);

}
