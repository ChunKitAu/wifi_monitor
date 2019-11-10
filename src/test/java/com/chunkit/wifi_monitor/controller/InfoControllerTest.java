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
    public void getInfoBySeekerId() {
        Long t1 = System.currentTimeMillis();
        System.out.println(t1);


    }
}