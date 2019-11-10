package com.chunkit.wifi_monitor.service.impl;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @auther ChunKit
 * @date 2019/10/17-14:49
 */
public class InfoServiceImplTest {

    @Test
    public void getMessage() {
        final String[] dataStr = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

        Long t = System.currentTimeMillis();

        int i = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1;

        List<String> d = new ArrayList<>();

        for (int j = 0; j < 7; j++) {
            d.add(dataStr[(7 + i) % 7]);
            i--;
        }
        Collections.reverse(d);
        System.out.println(d);
    }
}