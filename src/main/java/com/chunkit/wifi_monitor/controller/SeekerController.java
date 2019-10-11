package com.chunkit.wifi_monitor.controller;

import com.chunkit.wifi_monitor.entity.Msg;
import com.chunkit.wifi_monitor.entity.Seeker;
import com.chunkit.wifi_monitor.service.SeekerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @auther ChunKit
 * @date 2019/9/9-23:45
 */
@RequestMapping("/seeker")
@RestController
public class SeekerController {

    @Autowired
    SeekerService seekerService;

    /**
     * 查询表格数据
     * 导入jackson包
     * @param pn
     * @return
     */
    @GetMapping("/SelectAll")
    @ResponseBody
    public Msg getSeekerAll(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        //引入PageHelper分页插件
        //在查询前只需要,传入页码以及分页数
        PageHelper.startPage(pn, 10);
        //startPage后紧跟的这个查询就是一个分页查询
        List<Seeker> seekers = seekerService.getSeekerAll();
        PageInfo pageInfo = new PageInfo(seekers,5);
        return Msg.Success().add("pageInfo",pageInfo);
    }



    //传过来的是id  + isforbidden
    @PutMapping("/{id}/isForbidden={isForbidden}")
    @ResponseBody
    public Msg UpdateIsForbidden(@PathVariable("id") Integer id ,@PathVariable Integer isForbidden){
        if(seekerService.UpdateIsForbidden(id, isForbidden)){
            return Msg.Success();
        }else {
            return Msg.fail();
        }

    }


    @GetMapping("/selectByZoneId/{id}")
    @ResponseBody
    public Msg getSeekerByZoneId(@PathVariable("id") Integer id){
        List<Seeker> seekers = seekerService.getSeekerByZoneId(id);
        if (!seekers.isEmpty()){
            return Msg.Success().add("seekers",seekers);
        }else {
            return Msg.fail();
        }

    }


}
