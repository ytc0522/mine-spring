package org.example.mine.spring.beans.factory.registry;


/**
 * Bean对象注册表，用来存放单例的bean对象
 */
public interface SingletonBeanRegistry {


    /**
     * 将一个单例对象注册到Bean对象注册表中
     */
    void registerSingleton(String beanName, Object singleObject);


    /**
     * 从Bean对象注册表中根据名称获取Bean对象
     */
    Object getSingleton(String beanName);


}
