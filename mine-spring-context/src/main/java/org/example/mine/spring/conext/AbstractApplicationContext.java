package org.example.mine.spring.conext;

import org.example.mine.spring.beans.exceptions.BeanException;
import org.example.mine.spring.beans.factory.ConfigurableListableBeanFactory;
import org.example.mine.spring.beans.factory.DefaultListableBeanFactory;
import org.example.mine.spring.beans.factory.processor.BeanPostProcessor;
import org.example.mine.spring.conext.processor.ApplicationContextAwareProcessor;

import java.util.Map;

public abstract class AbstractApplicationContext implements ConfigurableApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    public void refresh() throws BeanException {

        refreshBeanFactory();

        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));

        registerBeanPostProcessors(beanFactory);

    }

    /**
     * 创建BeanFactory,加载BeanDefinition
     */
    protected abstract void refreshBeanFactory() throws BeanException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor processor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(processor);
        }
    }

}
