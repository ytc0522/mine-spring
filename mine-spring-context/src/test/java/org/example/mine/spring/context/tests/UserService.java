package org.example.mine.spring.context.tests;

public class UserService implements IUserService {

    private IUserDao userDao;


    public void sayHelloNoDao() {
        System.out.println("hello...");
    }

    @Override
    public void sayHello() {
        UserEntity user = userDao.getUser();
        System.out.println("user = " + user);
    }
}
