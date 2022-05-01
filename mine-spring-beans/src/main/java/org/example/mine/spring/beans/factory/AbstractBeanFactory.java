package org.example.mine.spring.beans.factory;

import cn.hutool.core.bean.BeanUtil;
import lombok.Getter;
import org.example.mine.spring.beans.BeanReference;
import org.example.mine.spring.beans.definition.BeanDefinition;
import org.example.mine.spring.beans.definition.BeanDefinitionRegistry;
import org.example.mine.spring.beans.definition.BeanField;
import org.example.mine.spring.beans.definition.BeanFields;
import org.example.mine.spring.beans.exceptions.BeanException;
import org.example.mine.spring.beans.factory.processor.BeanPostProcessor;
import org.example.mine.spring.beans.factory.strategy.BeanCreateStrategy;
import org.example.mine.spring.beans.factory.strategy.DefaultBeanCreateStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 这个抽象bean工厂类同时具备可配置、可列出bean、可自动注入的能力
 */
public abstract class AbstractBeanFactory implements ConfigurableListableBeanFactory, BeanDefinitionRegistry, AutowireCapableBeanFactory {

    /**
     * 用来存放Bean对象的容器
     */
    protected Map<String, Object> beansMap = new ConcurrentHashMap<>();

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
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public Object getBean(String name) {
        Object bean = beansMap.get(name);
        if (bean == null) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(name);
            if (beanDefinition != null) {
                return putBean(name, beanDefinition, null);
            }
        }
        return bean;
    }

    protected Object putBean(String beanName, BeanDefinition beanDefinition, Object... args) {
        // 创建Bean对象
        Object bean = getBeanCreateStrategy().createBean(beanDefinition, args);
        // 填充bean字段
        fillFields(beanDefinition, bean);
        // 放入到容器中
        beansMap.put(beanName, bean);
        return bean;
    }

    private void fillFields(BeanDefinition beanDefinition, Object bean) {
        BeanFields beanFields = beanDefinition.getBeanFields();
        if (beanFields == null) return;
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
        return null;
    }
}
