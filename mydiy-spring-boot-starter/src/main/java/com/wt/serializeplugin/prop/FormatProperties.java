package com.wt.serializeplugin.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = FormatProperties.FORMAT_PREFIX)
public class FormatProperties {
    public static final String FORMAT_PREFIX = "jackxu.format";
    public String type;
}
