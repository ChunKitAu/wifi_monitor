package com.chunkit.wifi_monitor.controller;

import com.chunkit.wifi_monitor.entity.Msg;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @auther ChunKit
 * @date 2019/9/16-22:37
 */
@Controller
public class SessionController {

    Msg msg;

    @PostMapping("/setIntegerSession/{key}={value}")
    @ResponseBody
    public Msg setIntegerSession(@PathVariable("key") String key,@PathVariable("value") Integer value, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute(key);
        session.setAttribute(key,value);
        return Msg.Success();
    }

    @PostMapping("/setStringSession/{key}={value}")
    @ResponseBody
    public Msg setStringSession(@PathVariable("key") String key,@PathVariable("value") String value, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute(key);
        session.setAttribute(key,value);
        return Msg.Success();
    }

    @GetMapping("/getSession/{key}")
    @ResponseBody
    public Msg getSession(@PathVariable("key")String key, HttpServletRequest request){
        if(request.getSession().getAttribute(key) != null){
            return msg.Success().add(key,request.getSession().getAttribute(key));
        }else return msg.fail();
    }



    @PostMapping("/removeSession/{key}")
    @ResponseBody
    public Msg removeSession(@PathVariable("key")String key, HttpServletRequest request){
            request.getSession().removeAttribute(key);
            return Msg.Success();
    }
}
