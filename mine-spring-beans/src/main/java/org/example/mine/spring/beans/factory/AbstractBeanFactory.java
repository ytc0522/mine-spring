package org.example.mine.spring.beans.factory;

import org.example.mine.spring.beans.BeanDefinition;
import org.example.mine.spring.beans.exceptions.BeanException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractBeanFactory implements BeanFactory {

    /**
     * 用来存放Bean对象的容器
     */
    protected Map<String, Object> beansMap = new ConcurrentHashMap<>();

    /**
     * 用来存放BeanDefinition定义的容器
     */
    protected Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();


    private BeanCreateStrategy beanCreateStrategy = new DefaultBeanCreateStrategy();

    public BeanCreateStrategy getBeanCreateStrategy() {
        return beanCreateStrategy;
    }

    @Override
    public Object getBean(String name) {
        Object bean = beansMap.get(name);
        if (bean == null) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(name);
            if (beanDefinition != null) {
                return putBean(name,beanDefinition, null);
            }
        }
        return bean;
    }

    protected abstract Object putBean(String beanName, BeanDefinition beanDefinition, Object... args);


    /**
     * 默认的Bean创建策略
     */
    class DefaultBeanCreateStrategy implements BeanCreateStrategy {

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

}
