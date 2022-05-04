package org.example.mini.spring.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.mine.spring.conext.annotation.Service;
import org.example.mini.spring.service.IUserService;

/**
 * 作者 xinyi
 * 日期 2022/5/2 8:20 PM
 */
@Slf4j
@Service("userServiceImpl")
public class UserService implements IUserService {

    @Override
    public String getUser() {
        return null;
    }

    @Override
    public void sayHello(String name) {
        log.info("Hello ~ {}", name);
    }
}
