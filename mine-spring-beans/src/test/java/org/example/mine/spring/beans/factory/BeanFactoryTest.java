package org.example.mine.spring.beans.factory;

import org.example.mine.spring.beans.BeanReference;
import org.example.mine.spring.beans.definition.BeanDefinition;
import org.example.mine.spring.beans.definition.BeanDefinitionHolder;
import org.example.mine.spring.beans.definition.BeanField;
import org.example.mine.spring.beans.definition.BeanFields;
import org.junit.Test;

public class BeanFactoryTest {


    @Test
    public void testClass() {
        boolean assignableFrom = IUserService.class.isAssignableFrom(UserService.class);
        System.out.println("assignableFrom = " + assignableFrom);

        boolean assignableFrom1 = Integer.class.isAssignableFrom(int.class);
        System.out.println("assignableFrom1 = " + assignableFrom1);


    }


    @Test
    public void testBeanFactory() {
        DefaultListableBeanFactory defaultBeanFactory = new DefaultListableBeanFactory();
        BeanDefinitionHolder beanDefinitionHolder = new BeanDefinitionHolder("userDao", new BeanDefinition(UserDao.class));

        // 注册
        defaultBeanFactory.registerBeanDefinition(beanDefinitionHolder);

        BeanFields beanFields = new BeanFields();
        beanFields.addBeanField(new BeanField("userDao", new BeanReference("userDao")));
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, beanFields);

        defaultBeanFactory.createBean(new BeanDefinitionHolder("userService", beanDefinition));

        UserService userService = (UserService) defaultBeanFactory.getBean("userService");
        userService.sayHello();

    }


}
