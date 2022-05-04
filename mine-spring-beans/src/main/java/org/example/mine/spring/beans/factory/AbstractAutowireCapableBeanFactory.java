package org.example.mine.spring.beans.factory;

import org.example.mine.spring.beans.definition.BeanDefinition;
import org.example.mine.spring.beans.definition.BeanDefinitionHolder;

/**
 * 作者 xinyi
 * 日期 2022/5/4 3:00 PM
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {


    /**
     * 完成对Bean对象的创建，并完成Bean对象的注册。
     */
    @Override
    protected Object createBean(BeanDefinitionHolder definitionHolder, Object... args) {
        BeanDefinition beanDefinition = definitionHolder.getBeanDefinition();
        String beanName = definitionHolder.getBeanName();
        // 创建Bean对象
        Object singletonObject = getBeanCreateStrategy().createBean(beanDefinition, args);
        // 填充bean字段
        fillFields(beanDefinition, singletonObject);
        // 放入到容器中
        registerSingleton(beanName, singletonObject);
        return singletonObject;
    }

    @Override
    public <T> T createBean(Class<T> beanClass) {
        BeanDefinition beanDefinition = new BeanDefinition(beanClass);
        return (T) createBean(new BeanDefinitionHolder(beanDefinition), null);
    }


}
