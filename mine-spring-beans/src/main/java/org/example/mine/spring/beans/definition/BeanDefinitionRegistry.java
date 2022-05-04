package org.example.mine.spring.beans.definition;

/**
 * 对Bean定义操作的抽象
 */
public interface BeanDefinitionRegistry {

    BeanDefinition getBeanDefinition(String beanName);

    void registerBeanDefinition(BeanDefinitionHolder definitionHolder);

    boolean containsBeanDefinition(String beanName);


}
