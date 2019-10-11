package com.chunkit.wifi_monitor.service;

import com.chunkit.wifi_monitor.entity.Path;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @auther ChunKit
 * @date 2019/10/10-16:13
 */
public interface PathService {

    public List<Path> getPathByMac(@PathVariable("mac") String mac);
}
