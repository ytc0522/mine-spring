package org.example.mine.spring.beans.factory;

import org.example.mine.spring.beans.BeanDefinition;

public class DefaultBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object putBean(String beanName, BeanDefinition beanDefinition, Object... args) {
        Object bean = getBeanCreateStrategy().createBean(beanDefinition, args);
        beansMap.put(beanName, bean);
        return bean;
    }
}
