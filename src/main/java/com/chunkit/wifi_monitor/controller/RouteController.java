package com.chunkit.wifi_monitor.controller;

import com.chunkit.wifi_monitor.entity.Msg;
import com.chunkit.wifi_monitor.entity.Path;
import com.chunkit.wifi_monitor.mapper.RouteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @auther ChunKit
 * @date 2019/9/22-10:14
 */
@Controller
public class RouteController {

    @Autowired
    RouteMapper routeMapper;

    @GetMapping("/route/{mac}")
    @ResponseBody
    public Msg getPathByMac(@PathVariable("mac") String mac){


        List<Path> paths = routeMapper.getPathByMac(mac);
        if(paths.isEmpty()){
            return Msg.fail();
        }else{
            return Msg.Success().add("routes",paths);
        }
    }

}
