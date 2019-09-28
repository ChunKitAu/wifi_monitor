package com.chunkit.wifi_monitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @auther ChunKit
 * @date 2019/9/12-14:38
 */
@Controller
public class redirectController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/map")
    public String toMap(){
        return "map";
    }

    @GetMapping("/path")
    public String toPathPage(){
        return "path";
    }

    @GetMapping("/route")
    public String toRoutePage(){
        return "route";
    }
}
