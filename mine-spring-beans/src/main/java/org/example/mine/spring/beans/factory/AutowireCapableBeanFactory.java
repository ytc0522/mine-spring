package org.example.mine.spring.beans.factory;

/**
 * 具备自动注入的bean工厂,主要对创建bean对象的行为的抽象
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 创建Bean对象
     */
    <T> T createBean(Class<T> beanClass);


    Object applyBeanPostProcessorBeforeBeanInit(Object existingBean, String beanName);


    Object applyBeanPostProcessorAfterBeanInit(Object existingBean, String beanName);


}
