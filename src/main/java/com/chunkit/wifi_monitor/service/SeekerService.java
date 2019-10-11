package com.chunkit.wifi_monitor.service;

import com.chunkit.wifi_monitor.entity.Seeker;

import java.util.List;

/**
 * @auther ChunKit
 * @date 2019/10/10-22:34
 */
public interface SeekerService {

    Seeker getSeekerById (Integer id);

    List<Seeker> getSeekerAll();

    List<Seeker> getSeekerByZoneId(Integer id);

    Boolean UpdateIsForbidden(Integer id,Integer isForbidden);

}
