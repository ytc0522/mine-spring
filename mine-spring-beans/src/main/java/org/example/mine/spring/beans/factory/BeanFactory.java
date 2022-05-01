package org.example.mine.spring.beans.factory;

import org.example.mine.spring.beans.definition.BeanDefinition;
import org.example.mine.spring.beans.exceptions.BeanException;

/**
 * Bean的工厂接口
 */
public interface BeanFactory {

    /**
     * 根据名称获取Bean对象
     */
    public Object getBean(String name);





}
