package com.wt.zerenlian.handlerImpl;

import com.wt.entity.Response;
import com.wt.zerenlian.AbstractHandler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 *  黑名单校验对象
 */
@Component
@Order(3) //校验顺序排第3
public class CheckBlackFilterObject extends AbstractHandler {

    @Override
    public void doFilter(HttpServletRequest request, Response response) {
        //invoke black list check
        System.out.println("校验黑名单");
    }
}