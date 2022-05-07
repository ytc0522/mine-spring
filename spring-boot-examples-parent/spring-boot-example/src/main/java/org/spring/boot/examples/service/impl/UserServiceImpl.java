package org.spring.boot.examples.service.impl;

import org.spring.boot.examples.entities.UserEntity;
import org.spring.boot.examples.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * 作者 xinyi
 * 日期 2022/5/7
 */
@Service
public class UserServiceImpl implements IUserService {


    @Override
    public UserEntity getUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(11);
        userEntity.setName("小李飞刀");
        return userEntity;
    }
}
