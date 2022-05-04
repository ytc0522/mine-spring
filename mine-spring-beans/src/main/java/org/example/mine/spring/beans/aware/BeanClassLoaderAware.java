package org.example.mine.spring.beans.aware;

public interface BeanClassLoaderAware extends Aware {


    void setBeanClassLoader(ClassLoader beanClassLoader);
}
