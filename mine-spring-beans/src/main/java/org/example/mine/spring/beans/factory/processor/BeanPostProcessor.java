package org.example.mine.spring.beans.factory.processor;

import org.example.mine.spring.beans.exceptions.BeanException;

public interface BeanPostProcessor {


    /**
     * 在 Bean对象执行初始化方法前，执行该方法
     */
    Object beforeBeanInit(Object bean, String beanName) throws BeanException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行该方法
     */
    Object afterBeanInit(Object bean, String beanName) throws BeanException;


}
