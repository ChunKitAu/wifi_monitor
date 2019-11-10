package com.chunkit.wifi_monitor.controller;

import com.chunkit.wifi_monitor.util.Msg;
import com.chunkit.wifi_monitor.entity.Path;
import com.chunkit.wifi_monitor.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @auther ChunKit
 * @date 2019/9/22-10:14
 */
@RestController
@RequestMapping("/path")
public class PathController {

    @Autowired
    PathService pathService;

    @GetMapping("/{mac}")
    public Msg getPathByMac(@PathVariable("mac") String mac) {

        List<Path> paths = pathService.getPathByMac(mac);

        if (paths.isEmpty()) {
            return Msg.fail();
        } else {
            return Msg.Success().add("routes", paths);
        }
    }

}
