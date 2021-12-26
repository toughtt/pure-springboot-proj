package com.wt.zerenlian.handlerImpl;

import com.wt.entity.Response;
import com.wt.zerenlian.AbstractHandler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 *  安全校验对象
 */
@Component
@Order(2) //校验顺序排第2
public class CheckSecurityFilterObject extends AbstractHandler {

    @Override
    public void doFilter(HttpServletRequest request, Response response) {
        //invoke Security check
        System.out.println("安全调用校验");
    }
}
