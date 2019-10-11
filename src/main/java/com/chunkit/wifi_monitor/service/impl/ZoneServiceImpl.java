package com.chunkit.wifi_monitor.service.impl;

import com.chunkit.wifi_monitor.entity.Zone;
import com.chunkit.wifi_monitor.mapper.ZoneMapper;
import com.chunkit.wifi_monitor.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther ChunKit
 * @date 2019/10/11-14:23
 */
@Service
public class ZoneServiceImpl implements ZoneService {

    @Autowired
    ZoneMapper zoneMapper;

    @Override
    public Zone getZoneById(Integer zone_id) {
        return zoneMapper.getZoneById(zone_id);
    }

    @Override
    public List<Zone> GetZoneAll() {
        return zoneMapper.GetZoneAll();
    }
}
