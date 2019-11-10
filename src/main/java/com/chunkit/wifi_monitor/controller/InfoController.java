package com.chunkit.wifi_monitor.controller;

import com.chunkit.wifi_monitor.entity.Info;
import com.chunkit.wifi_monitor.util.Msg;
import com.chunkit.wifi_monitor.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @auther ChunKit
 * @date 2019/9/18-23:17
 */

@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    InfoService infoService;

    @GetMapping("/selectBySeekerId/{id}")
    public Msg getInfoBySeekerIdAndMinute(@PathVariable("id") Integer id, HttpServletRequest request) {
        List<Info> infos = infoService.getInfoBySeekerIdAndMinute(id, request);

        if (!infos.isEmpty())
            return Msg.Success().add("infos", infos);
        else
            return Msg.fail();
    }


    @GetMapping("/selectBySeekerIdAndMac/{id}/{mac}")
    public Msg getInfoBySeekerIdAndMac(@PathVariable("id") Integer id, @PathVariable("mac") String mac) {

        List<Info> infos = infoService.getInfoBySeekerIdAndMac(id, mac);

        if (!infos.isEmpty())
            return Msg.Success().add("infos", infos);
        else
            return Msg.fail();
    }
}
