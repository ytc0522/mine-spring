package org.example.mine.spring.beans.factory.strategy;

import org.example.mine.spring.beans.definition.BeanDefinition;

/**
 * Bean创建策略
 */
public  interface BeanCreateStrategy {

    Object createBean(BeanDefinition beanDefinition, Object[] args);

}