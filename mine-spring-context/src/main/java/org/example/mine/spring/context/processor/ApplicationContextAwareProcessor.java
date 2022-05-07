package org.example.mine.spring.context.processor;

import org.example.mine.spring.beans.exceptions.BeanException;
import org.example.mine.spring.beans.factory.processor.BeanPostProcessor;
import org.example.mine.spring.context.ApplicationContext;
import org.example.mine.spring.context.aware.ApplicationContextAware;

public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Override
    public Object beforeBeanInit(Object bean, String beanName) throws BeanException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object afterBeanInit(Object bean, String beanName) throws BeanException {
        return bean;
    }
}
