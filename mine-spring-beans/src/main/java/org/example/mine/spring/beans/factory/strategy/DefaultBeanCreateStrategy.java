package org.example.mine.spring.beans.factory.strategy;

import org.example.mine.spring.beans.definition.BeanDefinition;
import org.example.mine.spring.beans.exceptions.BeanException;
import org.example.mine.spring.beans.factory.BeanFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 默认的Bean创建策略
 */
public class DefaultBeanCreateStrategy implements BeanCreateStrategy {

    @Override
    public Object createBean(BeanDefinition beanDefinition, Object[] args) throws BeanException {
        Class<?> beanClass = beanDefinition.getBeanClass();

        try {
            if (args == null || args.length == 0) {
                return beanClass.getDeclaredConstructor().newInstance();
            } else {
                for (Constructor<?> constructor : beanClass.getDeclaredConstructors()) {
                    if (constructor.getParameterCount() == args.length) {
                        return constructor.newInstance(args);
                    }
                }
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new BeanException("创建Bean对象失败,beanClass:" + beanDefinition.getBeanClass());
        }

        return null;
    }
}
