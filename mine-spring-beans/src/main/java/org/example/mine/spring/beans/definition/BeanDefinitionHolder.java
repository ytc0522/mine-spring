package org.example.mine.spring.beans.definition;

import lombok.Data;

/**
 * 作者 xinyi
 * 日期 2022/5/4 10:53 AM
 */

@Data
public class BeanDefinitionHolder {

    private final String beanName;
    private final BeanDefinition beanDefinition;

    public BeanDefinitionHolder(BeanDefinition beanDefinition) {
        this.beanDefinition = beanDefinition;
        this.beanName = beanDefinition.getBeanClass().getName();
    }

    public BeanDefinitionHolder(String beanName, BeanDefinition beanDefinition) {
        this.beanDefinition = beanDefinition;
        this.beanName = beanName;
    }


}
