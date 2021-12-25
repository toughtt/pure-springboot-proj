package org.example.controller;

import com.wt.serializeplugin.template.FormatTemplate;
import com.wt.service.MydiyHelloService;
import lombok.extern.slf4j.Slf4j;
import org.example.annotation.KthLog;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MydiyHelloService helloService;
    @Autowired
    private FormatTemplate formatTemplate;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    /**
     * function：切面日志测试
     * */
    @KthLog("这是入参减1的切面日志。。。")
    @RequestMapping("user/{id}")
    public User findUser(@PathVariable("id") Integer id) {
        log.info("Slf4j 记录的入参 id:" + id);
        return userService.findUserById(id);
    }

    /**
     * function：测试自定义starter
     * */
    @RequestMapping("/testStarter")
    public String testMyStarter() {
        return helloService.sayHello();
    }

/*    *
     * function：测试自定义starter(序列化插件：https://sg.jianshu.io/p/2d94ad2b7161)
     * */
    @RequestMapping("/testFormat")
    public String testFormat() {
        User user = new User(1234,"liantong0628");
        return formatTemplate.doFormate(user);
    }
}