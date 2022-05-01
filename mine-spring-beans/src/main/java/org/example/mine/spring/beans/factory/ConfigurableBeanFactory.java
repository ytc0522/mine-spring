package org.example.mine.spring.beans.factory;

import org.example.mine.spring.beans.factory.processor.BeanPostProcessor;

public interface ConfigurableBeanFactory extends BeanFactory {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);


}
