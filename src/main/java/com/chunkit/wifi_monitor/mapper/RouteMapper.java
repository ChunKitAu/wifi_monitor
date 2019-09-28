package com.chunkit.wifi_monitor.mapper;

import com.chunkit.wifi_monitor.entity.Path;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @auther ChunKit
 * @date 2019/9/22-10:15
 */
public interface RouteMapper {


    @Select("SELECT * FROM path where mac = #{mac}")
    //不使用的话部分返回值会为null
    @Results({
        @Result(column = "id",property = "id"),
        @Result(column = "mac",property = "mac"),
        @Result(column = "start_x",property = "start_x"),
        @Result(column = "start_y",property = "start_y"),
        @Result(column = "end_x",property = "end_x"),
        @Result(column = "end_y",property = "end_y"),
        @Result(column = "start_time",property = "start_time"),
        @Result(column = "end_time",property = "end_time"),
    })
    public List<Path> getPathByMac(String mac);
}
