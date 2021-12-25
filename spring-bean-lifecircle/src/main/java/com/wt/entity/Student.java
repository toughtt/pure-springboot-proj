package com.wt.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@EqualsAndHashCode(callSuper = true)
@Component
@Data
public class Student extends Person {
    private Integer grade;
    private String classroom;
    private Integer score;

    public Student() {
        super();
        System.out.println("【构造器】调用Student的构造器实例化");
    }

    @PostConstruct
    public void postConstructMethod() {
        System.out.println("execute Student postConstructMethod().");
    }
}
