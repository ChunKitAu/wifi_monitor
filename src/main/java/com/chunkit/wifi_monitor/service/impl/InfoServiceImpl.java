package com.chunkit.wifi_monitor.service.impl;

import com.chunkit.wifi_monitor.entity.Info;
import com.chunkit.wifi_monitor.mapper.InfoMapper;
import com.chunkit.wifi_monitor.service.InfoService;
import com.chunkit.wifi_monitor.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * @auther ChunKit
 * @date 2019/10/10-14:26
 */
@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    InfoMapper infoMapper;

    //根据时间和seekerid或ssi获取
    public List<Info> getInfoBySeekerIdAndMinute(Integer s_id, HttpServletRequest request) {
        Integer times = (Integer) request.getSession().getAttribute("times");
        Integer rssi = (Integer) request.getSession().getAttribute("rssi");

        List<Info> infos = infoMapper.getInfoBySeekerId(s_id);


        Long t = System.currentTimeMillis();
        List<Info> result = new ArrayList<>(infos);

        if (times != null)
            if (times != -1)
                for (Info info : infos) {
                    Long t2 = info.getTime().getTime();
                    if (t - t2 > times)
                        result.remove(info);
                }


        if (rssi != null) {
            for (Info info : infos) {
                if (info.getRssi() < rssi) {
                    result.remove(info);
                }
            }
        }

        return result;

    }


    public List<Info> getInfoBySeekerIdAndMac(Integer s_id, String mac) {

        List<Info> infos = infoMapper.getInfoBySeekerIdAndMac(s_id, mac);
        return infos;
    }


    //用于图表数据
    public Msg getMessage(Integer s_id, HttpServletRequest request) {

        Integer date = (Integer) request.getSession().getAttribute("date");

        final String[] dataStr = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

        //获取当前星期几
        int i = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1;

        List<String> xAxis = new ArrayList<>();

        for (int j = 0; j < 7; j++) {
            xAxis.add(dataStr[(7 + i) % 7]);
            i--;
        }
        Collections.reverse(xAxis);//数据反转

        //获取当前系统时间
        Long t = System.currentTimeMillis();

        List<Info> infos = infoMapper.getInfoBySeekerId(s_id);

        int[] num = new int[7];

        for (Info info : infos) {
            Long t2 = t - info.getTime().getTime();
            if (t2 < 86400000) {
                num[6]++;
            } else if (t2 < 172800000) {
                num[5]++;
            } else if (t2 < 259200000) {
                num[4]++;
            } else if (t2 < 345600000) {
                num[3]++;
            } else if (t2 < 432000000) {
                num[2]++;
            } else if (t2 < 518400000) {
                num[1]++;
            } else if (t2 < 604800000) {
                num[0]++;
            }
        }


        return Msg.Success().add("xAxis", xAxis).add("series", num);

    }

}
