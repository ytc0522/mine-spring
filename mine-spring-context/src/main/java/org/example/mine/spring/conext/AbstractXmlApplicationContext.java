package org.example.mine.spring.conext;

import lombok.extern.slf4j.Slf4j;
import org.example.mine.spring.beans.factory.DefaultListableBeanFactory;
import org.example.mine.spring.beans.io.XmlBeanDefinitionReader;

/**
 * 作者 xinyi
 * 日期 2022/5/1 10:27 PM
 */
@Slf4j
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader definitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocation = getConfigLocation();
        if (null != configLocation) {
            definitionReader.loadBeanDefinitions(configLocation);
        }

    }


    protected abstract String[] getConfigLocation();


}
