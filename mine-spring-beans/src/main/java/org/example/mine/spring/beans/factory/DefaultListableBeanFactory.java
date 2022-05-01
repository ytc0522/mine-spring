package org.example.mine.spring.beans.factory;

import org.example.mine.spring.beans.definition.BeanDefinitionRegistry;

public class DefaultListableBeanFactory extends AbstractBeanFactory implements BeanDefinitionRegistry {


    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }
}