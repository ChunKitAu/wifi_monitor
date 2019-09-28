package com.chunkit.wifi_monitor.controller;

import com.chunkit.wifi_monitor.entity.Info;
import com.chunkit.wifi_monitor.entity.Msg;
import com.chunkit.wifi_monitor.mapper.InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @auther ChunKit
 * @date 2019/9/18-23:17
 */
@Controller
public class InfoController {

    @Autowired
    InfoMapper infoMapper;

    @GetMapping("/getInfoByseekerId/{id}")
    @ResponseBody
    public Msg getInfoBySeekerId(@PathVariable("id")Integer id){

        List<Info> infos = infoMapper.getInfoBySeekerId(id);

        if(!infos.isEmpty())
            return Msg.Success().add("infos",infos);
        else
            return Msg.fail();
    }

    @GetMapping("/getInfoByseekerId/{id}&time = {time}")
    @ResponseBody
    public Msg getInfoBySeekerIdAndMinute(@PathVariable("id")Integer id,@PathVariable("time") Integer time){

        List<Info> infos = infoMapper.getInfoBySeekerId(id);
        Date date = new Date();
        for (Info info :infos) {
            Long times = date.getTime() - info.getTime().getTime();
            System.out.println(times);
        }


        if(!infos.isEmpty())
            return Msg.Success().add("infos",infos);
        else
            return Msg.fail();
    }

    @GetMapping("/getInfoByseekerIdAndMac/{id}&mac={mac}")
    @ResponseBody
    public Msg getInfoBySeekerIdAndMac(@PathVariable("id") Integer id ,@PathVariable("mac") String mac){

        List<Info> infos = infoMapper.getInfoBySeekerIdAndMac(id,mac);

        if(!infos.isEmpty())
            return Msg.Success().add("infos",infos);
        else
            return Msg.fail();
    }

}
