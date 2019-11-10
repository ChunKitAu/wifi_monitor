package com.chunkit.wifi_monitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther ChunKit
 * @date 2019/9/12-14:38
 */
@Controller
public class redirectController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/map")
    public String toMap(HttpServletRequest request) {
        request.getSession().setAttribute("times", 3600000);
        return "map";
    }

    @GetMapping("/path")
    public String toPathPage(HttpServletRequest request) {
        return "path";
    }

    @GetMapping("/route")
    public String toRoutePage() {
        return "route";
    }

    @GetMapping("/heatMap")
    public String toHotHeatmap() {
        return "heatmap";
    }

    @GetMapping("/seekers")
    public String toSeekerListPage() {
        return "crud/seeker_list";
    }

    @GetMapping("/zones")
    public String toZoneListPage() {
        return "crud/zone_list";
    }

    @GetMapping("/message")
    public String toMessagePage(HttpServletRequest request) {
        request.getSession().setAttribute("date", 604800000);
        return "message";
    }

}
