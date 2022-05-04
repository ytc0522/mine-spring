package org.example.mine.spring.beans.aware;

import org.example.mine.spring.beans.factory.BeanFactory;

public interface BeanFactoryAware extends Aware {
    void setBeanFactory(BeanFactory factory);
}
