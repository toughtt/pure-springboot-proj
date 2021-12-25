package com.wt.serializeplugin.processor;

import com.alibaba.fastjson.JSON;

public class FastjsonFormatProcessor implements FormatProcessor {
    @Override
    public <T> String format(T obj) {
        return "FastjsonFormatProcessor:" + JSON.toJSONString(obj);
    }
}
