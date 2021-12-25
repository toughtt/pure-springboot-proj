package com.wt.serializeplugin.template;

import com.wt.serializeplugin.processor.FormatProcessor;
import org.springframework.stereotype.Component;

@Component
public class FormatTemplate {
    private FormatProcessor formatProcessor;

    public FormatTemplate(FormatProcessor formatProcessor) {
        this.formatProcessor = formatProcessor;
    }

    public <T> String doFormate (T obj) {
        return formatProcessor.format(obj);
    }
}
