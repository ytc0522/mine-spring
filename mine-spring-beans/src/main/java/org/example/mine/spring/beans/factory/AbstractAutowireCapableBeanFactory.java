package org.example.mine.spring.beans.factory;

import org.example.mine.spring.beans.aware.Aware;
import org.example.mine.spring.beans.aware.BeanClassLoaderAware;
import org.example.mine.spring.beans.aware.BeanFactoryAware;
import org.example.mine.spring.beans.aware.BeanNameAware;
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
        applyPropertyValue(beanDefinition, singletonObject);

        // 放入到容器中
        registerSingleton(beanName, singletonObject);
        return singletonObject;
    }

    private Object initBean(String beanName, Object bean, BeanDefinition definition) {
        // 执行 Aware 方法
        if (bean instanceof Aware) {
            if (bean instanceof BeanFactoryAware) {
                ((BeanFactoryAware) bean).setBeanFactory(this);
            }
            if (bean instanceof BeanClassLoaderAware) {
                ((BeanClassLoaderAware) bean).setBeanClassLoader(getBeanClassLoader());
            }
            if (bean instanceof BeanNameAware) {
                ((BeanNameAware) bean).setBeanName(beanName);
            }
        }
        // 在对象初始化方法前 执行
        applyBeanPostProcessorBeforeBeanInit(bean, beanName);

        // 在对象初始后方法后 执行
        applyBeanPostProcessorAfterBeanInit(bean, beanName);

        return null;
    }

    @Override
    public <T> T createBean(Class<T> beanClass) {
        BeanDefinition beanDefinition = new BeanDefinition(beanClass);
        return (T) createBean(new BeanDefinitionHolder(beanDefinition), null);
    }


}
