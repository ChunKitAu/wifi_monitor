package com.chunkit.wifi_monitor.mapper;

import com.chunkit.wifi_monitor.entity.Seeker;
import com.chunkit.wifi_monitor.entity.Zone;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @auther ChunKit
 * @date 2019/9/9-22:53
 */
@Mapper
public interface ZoneMapper {

    @Select("select * from zone")
    public List<Zone> GetZoneAll();

    @Select("select * from zone where id = #{id}")
    public Zone getZoneById(Integer id);

}
