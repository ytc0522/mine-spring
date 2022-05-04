package org.example.mine.spring.beans.factory;

import cn.hutool.core.bean.BeanUtil;
import lombok.Getter;
import org.example.mine.spring.beans.BeanReference;
import org.example.mine.spring.beans.definition.*;
import org.example.mine.spring.beans.exceptions.BeanException;
import org.example.mine.spring.beans.factory.processor.BeanPostProcessor;
import org.example.mine.spring.beans.factory.registry.DefaultSingletonBeanRegistry;
import org.example.mine.spring.beans.factory.strategy.BeanCreateStrategy;
import org.example.mine.spring.beans.factory.strategy.DefaultBeanCreateStrategy;
import org.example.mine.spring.beans.util.ClassUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 这个抽象bean工厂类同时具备可配置、可列出bean、可自动注入的能力,
 * 同时，还具备
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableListableBeanFactory, BeanDefinitionRegistry, AutowireCapableBeanFactory {


    /**
     * 用来存放BeanDefinition定义的容器
     */
    protected Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    /**
     * Bean的创建策略
     */
    @Getter
    private final BeanCreateStrategy beanCreateStrategy = new DefaultBeanCreateStrategy();

    /**
     * Bean的处理器
     */
    @Getter
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    private final ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        return beanDefinitionMap.get(beanName);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeanException {
        Map<String, T> result = new HashMap<>();
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            if (type.isAssignableFrom(beanDefinition.getBeanClass())) {
                result.put(beanName, (T) getBean(beanName));
            }
        });
        return result;
    }

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        if (!this.beanPostProcessors.contains(beanPostProcessor)) {
            this.beanPostProcessors.add(beanPostProcessor);
        }
    }

    @Override
    public void registerBeanDefinition(BeanDefinitionHolder definitionHolder) {
        beanDefinitionMap.put(definitionHolder.getBeanName(), definitionHolder.getBeanDefinition());
    }

    @Override
    public Object getBean(String name) {
        Object bean = getSingleton(name);
        if (bean == null) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(name);
            if (beanDefinition != null) {
                return createBean(new BeanDefinitionHolder(name, beanDefinition), null);
            }
        }
        return bean;
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
        return (T) getBean(name);
    }

    protected abstract Object createBean(BeanDefinitionHolder definitionHolder, Object... args);

    protected void applyPropertyValue(BeanDefinition beanDefinition, Object bean) {
        BeanFields beanFields = beanDefinition.getBeanFields();
        if (beanFields == null || beanFields.getBeanFields() == null) return;
        for (BeanField beanField : beanFields) {
            // 判断是否是Bean对象
            if (beanField.getValue() instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) beanField.getValue();
                Object fieldVal = getBean(beanReference.getBeanName());
                BeanUtil.setFieldValue(bean, beanField.getName(), fieldVal);
            } else {
                BeanUtil.setFieldValue(bean, beanField.getName(), beanField.getValue());
            }
        }
    }

    @Override
    public Object applyBeanPostProcessorAfterBeanInit(Object existingBean, String beanName) {
        return null;
    }

    @Override
    public Object applyBeanPostProcessorBeforeBeanInit(Object existingBean, String beanName) {

        List<BeanPostProcessor> beanPostProcessors = getBeanPostProcessors();


        return null;
    }

    public ClassLoader getBeanClassLoader() {
        return beanClassLoader;
    }
}
