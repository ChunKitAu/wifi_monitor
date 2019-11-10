package com.chunkit.wifi_monitor.mapper;

import com.chunkit.wifi_monitor.entity.Path;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @auther ChunKit
 * @date 2019/9/22-10:15
 */
public interface PathMapper {


    @Select("SELECT * FROM path where mac = #{mac}")
    //不使用的话部分返回值会为null
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "mac", property = "mac"),
            @Result(column = "start_x", property = "start_x"),
            @Result(column = "start_y", property = "start_y"),
            @Result(column = "end_x", property = "end_x"),
            @Result(column = "end_y", property = "end_y"),
            @Result(column = "start_time", property = "start_time"),
            @Result(column = "end_time", property = "end_time"),
    })
    public List<Path> getPathByMac(String mac);

    @Select("<script>" +
            "insert into path (mac,start_x,start_y,end_x,end_y,start_time,end_time) values" +
            "<foreach collection='list' item='item' index='index' separator=','>" +
            "(#{item.mac},#{item.start_x},#{item.start_y},#{item.end_x},#{item.end_y},#{item.start_time},#{item.end_time})" +
            "</foreach>" +
            "</script>")
    public void insertPaths(List<Path> paths);
}
