package com.chunkit.wifi_monitor.controller;

import com.chunkit.wifi_monitor.entity.Seeker;
import com.chunkit.wifi_monitor.entity.Zone;
import com.chunkit.wifi_monitor.service.SeekerService;
import com.chunkit.wifi_monitor.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auther ChunKit
 * @date 2019/10/11-14:57
 */
@Controller
public class ToEditPageController {

    @Autowired
    ZoneService zoneService;

    @Autowired
    SeekerService seekerService;

    @GetMapping("/toSeekerEditPage/{id}")
    public String ToSeekerEditPage(@PathVariable("id") Integer id, Model model) {
        Seeker seeker = seekerService.getSeekerById(id);
        model.addAttribute("seeker", seeker);
        return "crud/seeker_add";
    }


    @GetMapping("/toZoneEditPage/{id}")
    public String ToZoneEditPage(@PathVariable("id") Integer id, Model model) {
        Zone zone = zoneService.getZoneById(id);
        model.addAttribute("zone", zone);
        return "crud/zone_add";
    }
}
