package org.example.mine.spring.beans.definition;

import org.example.mine.spring.beans.io.Resource;

/**
 * 作者 xinyi
 * 日期 2022/5/1 10:28 PM
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(Resource... resources);

    void loadBeanDefinitions(String... locations);


}
