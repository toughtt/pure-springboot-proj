package com.wt.serializeplugin.config;

import com.wt.serializeplugin.processor.FastjsonFormatProcessor;
import com.wt.serializeplugin.processor.FormatProcessor;
import com.wt.serializeplugin.processor.GsonFormatProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class FormatAutoConfiguration {
    @Bean

    public FormatProcessor fastjsonFormat() {
        return new FastjsonFormatProcessor();
    }

    @Bean
    @Primary//此注解放在哪里，优先调用该种方法实例化FormatProcessor对象
    public FormatProcessor gsonFormat() {
        return new GsonFormatProcessor();
    }
}
