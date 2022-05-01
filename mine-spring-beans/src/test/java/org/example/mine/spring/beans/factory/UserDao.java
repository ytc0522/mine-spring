package org.example.mine.spring.beans.factory;

public class UserDao implements IUserDao {


    @Override
    public UserEntity getUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(11);
        userEntity.setName("李小龙");
        return userEntity;
    }
}
