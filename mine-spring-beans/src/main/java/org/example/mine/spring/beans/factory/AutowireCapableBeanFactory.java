package org.example.mine.spring.beans.factory;

/**
 * 具备自动注入的bean工厂
 */
public interface AutowireCapableBeanFactory extends BeanFactory {


    Object applyBeanPostProcessorBeforeBeanInit(Object existingBean, String beanName);


    Object applyBeanPostProcessorAfterBeanInit(Object existingBean, String beanName);


}
