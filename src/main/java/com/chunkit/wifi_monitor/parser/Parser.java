package com.chunkit.wifi_monitor.parser;


import java.util.Map;

public interface Parser {
    public Map<String, Object> parse(String strParsed, String separator);
}
