package com.chunkit.wifi_monitor.parser;

import com.chunkit.wifi_monitor.entity.Info;
import com.chunkit.wifi_monitor.entity.Path;
import com.chunkit.wifi_monitor.entity.Seeker;

import java.util.List;


public interface PathTracer {
    public List<Path> trace(List<Info> infos, Seeker seeker);
}
