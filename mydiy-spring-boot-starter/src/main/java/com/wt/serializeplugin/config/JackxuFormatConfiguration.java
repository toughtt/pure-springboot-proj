package com.wt.serializeplugin.config;

import com.wt.serializeplugin.processor.FastjsonFormatProcessor;
import com.wt.serializeplugin.processor.FormatProcessor;
import com.wt.serializeplugin.processor.GsonFormatProcessor;
import com.wt.serializeplugin.prop.FormatProperties;
import com.wt.serializeplugin.template.FormatTemplate;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(FormatAutoConfiguration.class)
@EnableConfigurationProperties(FormatProperties.class)
@Configuration
public class JackxuFormatConfiguration {

    @Bean
    public FormatTemplate helloFormatTemplate(FormatProperties formatProperties, FormatProcessor formatProcessor) {
        if("fastjson".equals(formatProperties.getType())) {
            return new FormatTemplate(new FastjsonFormatProcessor());
        }
        if("gson".equals(formatProperties.getType())) {
            return new FormatTemplate(new GsonFormatProcessor());
        }
        return new FormatTemplate(formatProcessor);
    }
}
