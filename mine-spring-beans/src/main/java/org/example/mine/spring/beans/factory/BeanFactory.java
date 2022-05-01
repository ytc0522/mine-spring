package org.example.mine.spring.beans.factory;

import org.example.mine.spring.beans.BeanDefinition;
import org.example.mine.spring.beans.exceptions.BeanException;

import java.lang.reflect.Constructor;

/**
 * Bean的工厂接口
 */
public interface BeanFactory {

    /**
     * 根据名称获取Bean对象
     */
    public Object getBean(String name);


    /**
     * Bean创建策略
     */
    interface BeanCreateStrategy {

        Object createBean(BeanDefinition beanDefinition, Object[] args) throws BeanException;

    }


}
