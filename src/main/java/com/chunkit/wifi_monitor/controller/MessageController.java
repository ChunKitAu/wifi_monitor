package com.chunkit.wifi_monitor.controller;

import com.chunkit.wifi_monitor.service.InfoService;
import com.chunkit.wifi_monitor.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther ChunKit
 * @date 2019/10/16-22:34
 */
@RequestMapping("/message")
@RestController
public class MessageController {

    @Autowired
    InfoService infoService;

    @GetMapping("/week/{s_id}")
    public Msg GetInfoByTimesAndSeekerId(@PathVariable("s_id") Integer s_id, HttpServletRequest request) {
        return infoService.getMessage(s_id, request);
    }

}
