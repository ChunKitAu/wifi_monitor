package com.chunkit.wifi_monitor.service;

import com.chunkit.wifi_monitor.entity.Zone;

import java.util.List;

/**
 * @auther ChunKit
 * @date 2019/10/11-14:23
 */
public interface ZoneService {

    Zone getZoneById(Integer zone_id);

    List<Zone> GetZoneAll();
}
