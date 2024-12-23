package com.library.library_management;

import org.springframework.stereotype.Component;

@Component // 1- spring will create instance form this class (bean)
public class HelloService {
    public String sayHello(){
        return "hello spring form bean !!!!!";
    }
}