package org.example.mine.spring.beans.factory;

public class UserService implements IUserService{

    private  IUserDao userDao;


    @Override
    public void sayHello() {
        UserEntity user = userDao.getUser();
        System.out.println("user = " + user);
    }
}
