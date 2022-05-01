package org.example.mine.spring.beans.definition;

import lombok.Data;


@Data
public class BeanDefinition {

    private Class<?> beanClass;

    private BeanFields beanFields;

    private String initMethodName;

    private String destroyMethodName;


    public BeanDefinition(Class<?> beanClass, BeanFields beanFields) {
        this.beanClass = beanClass;
        this.beanFields = beanFields;
    }

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
    }


    public void setInitMethodName(String initMethod) {

    }

    public void setDestroyMethodName(String destroyMethodName) {

    }

    public void setScope(String beanScope) {

    }
}
