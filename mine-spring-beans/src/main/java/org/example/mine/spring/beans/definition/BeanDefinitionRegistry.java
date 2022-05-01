package org.example.mine.spring.beans.definition;

public interface BeanDefinitionRegistry {

    BeanDefinition getBeanDefinition(String beanName);

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);


}
