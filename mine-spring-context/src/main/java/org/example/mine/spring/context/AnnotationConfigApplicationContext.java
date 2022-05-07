package org.example.mine.spring.context;

import cn.hutool.core.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.example.mine.spring.beans.definition.BeanDefinitionHolder;
import org.example.mine.spring.beans.factory.DefaultListableBeanFactory;
import org.example.mine.spring.context.annotation.AnnotationConfigRegistry;
import org.example.mine.spring.context.annotation.BeanDefinitionScanner;

import java.util.Set;

@Slf4j
public class AnnotationConfigApplicationContext extends AbstractRefreshableApplicationContext implements AnnotationConfigRegistry {


    private final BeanDefinitionScanner scanner;

    public AnnotationConfigApplicationContext() {
        scanner = new BeanDefinitionScanner();
        refresh();
    }


    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {

    }

    @Override
    public void register(Class<?>... componentClass) {

    }

    @Override
    public void scan(String... basePackages) {
        Assert.notEmpty(basePackages, "At least one base package must be specified");
        Set<BeanDefinitionHolder> beanDefinitionHolders = this.scanner.scan(basePackages);
        for (BeanDefinitionHolder definitionHolder : beanDefinitionHolders) {
            getBeanFactory().registerBeanDefinition(definitionHolder);
        }

    }
}
