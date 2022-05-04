package org.example.mine.spring.beans.aware;


public interface BeanNameAware extends Aware {

    void setBeanName(String beanName);

}
