package org.example.mine.spring.context.annotation;

public interface AnnotationConfigRegistry {

    /**
     * 注册一个或多个component 类
     */
    void register(Class<?>... componentClass);

    /**
     * 扫描指定的包,将扫描到的BeanClass生成的BeanDefinition后注册到容器中。
     */
    void scan(String... basePackages);

}
