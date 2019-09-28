package com.chunkit.wifi_monitor.controller;

import com.chunkit.wifi_monitor.entity.Info;
import com.chunkit.wifi_monitor.mapper.InfoMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @auther ChunKit
 * @date 2019/9/27-15:20
 */
public class InfoControllerTest {

    @Autowired
    InfoMapper infoMapper;

    @Test
    public void getInfoBySeekerId() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println(sdf.format(date));
        Date date2 = sdf.parse("2019-09-27 06:48:53");
        System.out.println(date.getTime());
        System.out.println(date2.getTime());
    }
}