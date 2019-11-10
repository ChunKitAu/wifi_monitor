package com.chunkit.wifi_monitor.mapper;

import com.chunkit.wifi_monitor.entity.Info;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @auther ChunKit
 * @date 2019/9/18-23:06
 */
public interface InfoMapper {


    @Select("select * from info where s_id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "rssi", property = "rssi"),
            @Result(column = "mac", property = "mac"),
            @Result(column = "time", property = "time"),
            @Result(column = "s_id", property = "s_id"),
    })
    public List<Info> getInfoBySeekerId(Integer id);

    @Select("select * from info where s_id =#{id} and mac = #{mac}")
    public List<Info> getInfoBySeekerIdAndMac(Integer id, String mac);

    @Insert("insert ignore into seeker (id,type,x,y) values(#{id},#{type},#{x},#{y})")
    public void insertSeeker(Integer id, Integer type, double x, double y);

    @Insert("<script>" +
            "insert ignore into info(rssi,mac,s_id) values " +
            "<foreach collection='list' item='item' index='index' separator=','>" +
            "(#{item.rssi},#{item.mac},#{item.s_id})" +
            "</foreach>" +
            "</script>")
    public void insertInfos(List<Info> infos);

}
