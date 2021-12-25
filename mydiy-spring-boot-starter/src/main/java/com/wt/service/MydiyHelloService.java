package com.wt.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class MydiyHelloService {

    private String msg;

    public String sayHello() {
        return "hello " + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
