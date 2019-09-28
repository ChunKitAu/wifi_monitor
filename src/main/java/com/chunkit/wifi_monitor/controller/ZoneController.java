package com.chunkit.wifi_monitor.controller;

import com.chunkit.wifi_monitor.entity.Msg;
import com.chunkit.wifi_monitor.entity.Seeker;
import com.chunkit.wifi_monitor.entity.Zone;
import com.chunkit.wifi_monitor.mapper.ZoneMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @auther ChunKit
 * @date 2019/9/9-19:40
 */
@Controller
public class ZoneController {

    @Autowired
    ZoneMapper zoneMapper;

    @GetMapping("/zones")
    public String toZoneListPage(){
        return "crud/zone_list";
    }

    @RequestMapping(value = "/zoneSelectAll")
    @ResponseBody
    public Msg getZoneAll(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        //引入PageHelper分页插件
        //在查询前只需要,传入页码以及分页数
        PageHelper.startPage(pn, 10);
        //startPage后紧跟的这个查询就是一个分页查询
        List<Zone> zones = zoneMapper.GetZoneAll();
        PageInfo pageInfo = new PageInfo(zones,5);
        return Msg.Success().add("pageInfo",pageInfo);
    }

    @GetMapping("/zone/{id}")
    public String ToEditSeekerPage(@PathVariable("id") Integer id, Model model){

        Zone zone = zoneMapper.getZoneById(id);
        model.addAttribute("zone",zone);

        return "crud/zone_add";
    }

    @GetMapping("getZoneById/{id}")
    @ResponseBody
    public Msg getZoneById(@PathVariable("id") Integer id){
        Zone zone = zoneMapper.getZoneById(id);
        return Msg.Success().add("zone",zone);
    }

}
