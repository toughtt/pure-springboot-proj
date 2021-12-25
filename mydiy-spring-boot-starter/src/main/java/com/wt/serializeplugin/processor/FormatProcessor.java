package com.wt.serializeplugin.processor;

public interface FormatProcessor {
    <T> String format(T obj);
}
