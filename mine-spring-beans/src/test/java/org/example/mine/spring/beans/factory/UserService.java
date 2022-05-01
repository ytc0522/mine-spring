package org.example.mine.spring.beans.factory;

public class UserService {

    private String name;

    private Integer age;


    public String sayHello() {
        return "hello " + this.name;
    }

}
