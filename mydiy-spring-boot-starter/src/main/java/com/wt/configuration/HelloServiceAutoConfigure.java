package com.wt.configuration;

import com.wt.prop.HelloServiceProperties;
import com.wt.service.MydiyHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(MydiyHelloService.class)
@EnableConfigurationProperties(HelloServiceProperties.class)
@ConditionalOnProperty(prefix = "hello",value = "enable",matchIfMissing = true)
public class HelloServiceAutoConfigure {
    @Autowired
    private HelloServiceProperties helloServiceProperties;
    @Bean
    public MydiyHelloService helloService() {
        MydiyHelloService helloService = new MydiyHelloService();
        helloService.setMsg(helloServiceProperties.getMsg());
        return helloService;
    }

}
