package com.chunkit.wifi_monitor.controller;

import com.chunkit.wifi_monitor.entity.Info;
import com.chunkit.wifi_monitor.entity.Msg;
import com.chunkit.wifi_monitor.mapper.InfoMapper;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @auther ChunKit
 * @date 2019/9/18-23:17
 */
@Controller
public class InfoController {

    @Autowired
    InfoMapper infoMapper;

    //根据时间和seekerid获取
    @GetMapping("/getInfoByseekerId/{id}")
    @ResponseBody
    public Msg getInfoBySeekerIdAndMinute(@PathVariable("id")Integer id, HttpServletRequest request){
        Integer times = (Integer)request.getSession().getAttribute("times");
        Integer rssi  = (Integer)request.getSession().getAttribute("rssi");

        List<Info> infos = infoMapper.getInfoBySeekerId(id);

        Long t = System.currentTimeMillis();
        List<Info> result = new ArrayList<>(infos);


        if(times != -1|| times != null){
            for (Info info: infos) {
                Long t2 = info.getTime().getTime();
                if(t - t2 > times){
                    result.remove(info);
                }
            }
        }


        if(rssi != null){
            for (Info info: infos) {
                if(info.getRssi() < rssi){
                    result.remove(info);
                }
            }
        }

        if(!result.isEmpty())
            return Msg.Success().add("infos",result);
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
