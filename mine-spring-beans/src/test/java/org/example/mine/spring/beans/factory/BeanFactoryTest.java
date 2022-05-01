package org.example.mine.spring.beans.factory;

import org.example.mine.spring.beans.BeanDefinition;
import org.junit.Test;

public class BeanFactoryTest {


    @Test
    public void testBeanFactory() {
        DefaultBeanFactory defaultBeanFactory = new DefaultBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanName("userService");
        beanDefinition.setBeanClass(UserService.class);
        defaultBeanFactory.putBean(beanDefinition);

        Object userService = defaultBeanFactory.getBean("userService");
        System.out.println("userService = " + userService);
    }


}
