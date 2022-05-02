package org.example.mine.spring.conext;


import org.example.mine.spring.conext.tests.UserService;
import org.junit.Test;

public class ClassPathXmlApplicationContextTest {

    @Test
    public void testApplicationContext() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");


        UserService userService = context.getBean("userService", UserService.class);
        userService.sayHelloNoDao();

    }


}