package com.wt.zerenlian.handlerImpl;

import com.wt.entity.Response;
import com.wt.zerenlian.AbstractHandler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 *  规则拦截对象
 */
@Component
@Order(4) //校验顺序排第4
public class CheckRuleFilterObject extends AbstractHandler {

    @Override
    public void doFilter(HttpServletRequest request, Response response) {
        //check rule
        System.out.println("check rule");
    }
}
