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

    //添加选取地图的id
    @PostMapping("/setSessionZoneId/{id}")
    @ResponseBody
    public Msg setSessionZoneId(@PathVariable("id") Integer id, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("zoneId");
        session.setAttribute("zoneId",id);
        return Msg.Success();
    }

    @GetMapping("/getSessionZoneId")
    @ResponseBody
    public Msg getSessionZoneId(HttpServletRequest request){

        if(request.getSession().getAttribute("zoneId") != null){
            return msg.Success().add("zoneId",request.getSession().getAttribute("zoneId").toString());
        }else return msg.fail();
    }

    //添加选取设备的id
    @PostMapping("/SetSessionseekerId/{seekerId}")
    @ResponseBody
    public Msg SetSessionseekerId(@PathVariable("seekerId") Integer seekerId, HttpServletRequest request){
        System.out.println(seekerId);
        HttpSession session = request.getSession();
        session.removeAttribute("seekerId");
        session.setAttribute("seekerId",seekerId);
        return Msg.Success();
    }


    @GetMapping("/getSessionseekerId")
    @ResponseBody
    public Msg getSessionseekerId(HttpServletRequest request){

        if(request.getSession().getAttribute("seekerId") != null){
            return msg.Success().add("seekerId",request.getSession().getAttribute("seekerId").toString());
        }else return msg.fail();
    }

    @PostMapping("/setSessionMac/{mac}")
    @ResponseBody
    public Msg setSessionMac(@PathVariable("mac") String mac, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("mac");
        session.setAttribute("mac",mac);
        return Msg.Success();
    }

    @GetMapping("/getSessionMac")
    @ResponseBody
    public Msg getSessionMac(HttpServletRequest request){

        if(request.getSession().getAttribute("mac") != null){
            return msg.Success().add("mac",request.getSession().getAttribute("mac").toString());
        }else return msg.fail();
    }

}
