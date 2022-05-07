package org.example.mine.spring.context;

import org.example.mine.spring.beans.exceptions.BeanException;
import org.example.mine.spring.beans.factory.DefaultListableBeanFactory;

/**
 * 作者 xinyi
 * 日期 2022/5/1 10:22 PM
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }


    @Override
    protected void refreshBeanFactory() throws BeanException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        this.beanFactory = beanFactory;
        loadBeanDefinitions(this.beanFactory);
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);


    @Override
    public DefaultListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
