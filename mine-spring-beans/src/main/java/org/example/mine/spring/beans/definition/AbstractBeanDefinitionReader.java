package org.example.mine.spring.beans.definition;

import lombok.Getter;
import org.example.mine.spring.beans.io.ResourceLoader;

/**
 * 作者 xinyi
 * 日期 2022/5/1 10:42 PM
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    @Getter
    private final BeanDefinitionRegistry registry;

    @Getter
    private final ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, null);
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }
}
