package com.chunkit.wifi_monitor.controller;

import com.chunkit.wifi_monitor.entity.Msg;
import com.chunkit.wifi_monitor.entity.Seeker;
import com.chunkit.wifi_monitor.mapper.SeekerMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @auther ChunKit
 * @date 2019/9/9-23:45
 */
@Controller
public class SeekerController {

    @Autowired
    SeekerMapper seekerMapper;

    @GetMapping("/seekers")
    public String toSeekerListPage(){
        return "crud/seeker_list";
    }


    /**
     * 查询表格数据
     * 导入jackson包
     * @param pn
     * @return
     */
    @GetMapping("/seekerSelectAll")
    @ResponseBody
    public Msg getSeekerAll(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        //引入PageHelper分页插件
        //在查询前只需要,传入页码以及分页数
        PageHelper.startPage(pn, 10);
        //startPage后紧跟的这个查询就是一个分页查询
        List<Seeker> seekers = seekerMapper.getSeekerAll();
        PageInfo pageInfo = new PageInfo(seekers,5);
        return Msg.Success().add("pageInfo",pageInfo);
    }


    @GetMapping("/seeker/{id}")
    public String ToEditSeekerPage(@PathVariable("id") Integer id, Model model){

        Seeker seeker = seekerMapper.getSeekerById(id);
        model.addAttribute("seeker",seeker);

        return "crud/seeker_add";
    }


    //传过来的是id  + isforbidden
    @PutMapping("/seeker/{id}")
    @ResponseBody
    public Msg EditIsForbidden(@PathVariable("id") Integer number ){
        Integer id = number /10;
        Integer isForbidden = number%10;
        int i = seekerMapper.EditIsForbidden(id, isForbidden);
        if(i > 0){
            return Msg.Success();
        }else {
            return Msg.fail();
        }

    }


    @GetMapping("/getSeekerByZoneId/{id}")
    @ResponseBody
    public Msg getSeekerByZoneId(@PathVariable("id") Integer id){
        List<Seeker> seekers = seekerMapper.getSeekerByZoneId(id);
        if (!seekers.isEmpty()){
            return Msg.Success().add("seekers",seekers);
        }else {
            return Msg.fail();
        }

    }


}
