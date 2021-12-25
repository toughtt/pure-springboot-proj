package com.wt;

import com.wt.conf.AppConfig;
import com.wt.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//https://blog.csdn.net/luzhensmart/article/details/87993232
public class BeanLifeCycle {
    public static void main(String[] args) {
        System.out.println("现在开始初始化容器----------------------------------------------------");
        ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("容器初始化成功----------------------------------------------------");
        //得到Preson，并使用
        Person person = factory.getBean("person",Person.class);

        System.out.println(person);

        System.out.println("现在开始关闭容器！");
        ((ClassPathXmlApplicationContext)factory).registerShutdownHook();
    }
}
//扩展学习--2w 字搞懂 Spring Bean 的一生： https://cloud.tencent.com/developer/article/1830984