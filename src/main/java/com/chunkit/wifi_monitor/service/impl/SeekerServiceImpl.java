package com.chunkit.wifi_monitor.service.impl;

import com.chunkit.wifi_monitor.entity.Seeker;
import com.chunkit.wifi_monitor.mapper.SeekerMapper;
import com.chunkit.wifi_monitor.service.SeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther ChunKit
 * @date 2019/10/10-22:34
 */
@Service
public class SeekerServiceImpl implements SeekerService {

    @Autowired
    SeekerMapper seekerMapper;


    @Override
    public Seeker getSeekerById(Integer id) {
        return seekerMapper.getSeekerById(id);
    }

    @Override
    public List<Seeker> getSeekerAll() {
        return seekerMapper.getSeekerAll();
    }

    @Override
    public List<Seeker> getSeekerByZoneId(Integer id) {
        return seekerMapper.getSeekerByZoneId(id);
    }

    @Override
    public Boolean UpdateIsForbidden(Integer id, Integer isForbidden) {
        System.out.println(isForbidden);
        if (seekerMapper.UpdateIsForbidden(id, isForbidden) != -1) {
            return true;
        }
        return false;
    }
}
