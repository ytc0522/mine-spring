package org.example.mine.spring.beans.definition;

import org.example.mine.spring.beans.definition.BeanDefinition;

public interface BeanDefinitionRegistry {

    BeanDefinition getBeanDefinition(String beanName);

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);


}
