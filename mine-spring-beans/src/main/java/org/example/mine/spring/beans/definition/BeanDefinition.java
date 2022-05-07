package org.example.mine.spring.beans.definition;

import lombok.Data;


@Data
public class BeanDefinition {

    private Class<?> beanClass;

    private BeanFields beanFields;

    private String initMethodName;

    private String destroyMethodName;

    private String scope;


    public BeanDefinition(Class<?> beanClass, BeanFields beanFields) {
        this.beanClass = beanClass;
        this.beanFields = beanFields == null ? new BeanFields() : beanFields;
    }

    public BeanDefinition(Class<?> beanClass) {
        this(beanClass, null);
    }


    public void setInitMethodName(String initMethod) {
        this.initMethodName = initMethod;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }

    public void setScope(String beanScope) {
        this.scope = beanScope;
    }
}
