package com.wt.controller;

import com.wt.entity.Response;
import com.wt.zerenlian.service.ChainPatternDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DesignPatternCallController {

    @Autowired
    private ChainPatternDemo chainPatternDemo;


    /**
     * function：测试责任链方法
     * 实战！工作中常用到哪些设计模式
     * https://blog.csdn.net/weixin_31351409/article/details/121005589
     * */
    @RequestMapping("/callHandlerChain")
    public Response<String> callHandlerChain (HttpServletRequest request) {
        Response<String> response = new Response<>();
        return chainPatternDemo.exec(request, response);
    }
}
