package com.chunkit.wifi_monitor.service.impl;

import com.chunkit.wifi_monitor.entity.Info;
import com.chunkit.wifi_monitor.entity.Msg;
import com.chunkit.wifi_monitor.mapper.InfoMapper;
import com.chunkit.wifi_monitor.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther ChunKit
 * @date 2019/10/10-14:26
 */
@Service
public class InfoServiceImpl  implements InfoService {

    @Autowired
    InfoMapper infoMapper;

    //根据时间和seekerid获取
    public List<Info> getInfoBySeekerIdAndMinute(Integer s_id, HttpServletRequest request){
        Integer times = (Integer)request.getSession().getAttribute("times");
        Integer rssi  = (Integer)request.getSession().getAttribute("rssi");

        List<Info> infos = infoMapper.getInfoBySeekerId(s_id);


        Long t = System.currentTimeMillis();
        List<Info> result = new ArrayList<>(infos);

        if(times != null)
            if(times != -1)
                for (Info info: infos) {
                    Long t2 = info.getTime().getTime();
                    if(t - t2 > times)
                        result.remove(info);
                }



        if(rssi != null){
            for (Info info: infos) {
                if(info.getRssi() < rssi){
                    result.remove(info);
                }
            }
        }

        return  result;

    }


    public List<Info> getInfoBySeekerIdAndMac(Integer s_id , String mac){

        List<Info> infos = infoMapper.getInfoBySeekerIdAndMac(s_id,mac);
        return infos;
    }
}
