package com.example;

import org.springframework.stereotype.Service;

/**
 * Created by paul on 16/11/24.
 */
@Service("HelloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public Person sayHello(String name) {
        Person person=new Person();
        person.setName(name);
        person.setSex(1);
        return person;
    }
}
