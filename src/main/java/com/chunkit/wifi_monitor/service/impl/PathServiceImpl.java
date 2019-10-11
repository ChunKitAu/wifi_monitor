package com.chunkit.wifi_monitor.service.impl;

import com.chunkit.wifi_monitor.entity.Path;
import com.chunkit.wifi_monitor.mapper.PathMapper;
import com.chunkit.wifi_monitor.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther ChunKit
 * @date 2019/10/10-16:17
 */
@Service
public class PathServiceImpl implements PathService {


    @Autowired
    PathMapper pathMapper;

    @Override
    public List<Path> getPathByMac(String mac) {
        List<Path> paths = pathMapper.getPathByMac(mac);
        return paths;
    }
}
