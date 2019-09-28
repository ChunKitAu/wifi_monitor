package com.chunkit.wifi_monitor.mapper;

import com.chunkit.wifi_monitor.entity.Seeker;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @auther ChunKit
 * @date 2019/9/9-23:46
 */
public interface SeekerMapper {

    @Select("select * from seeker")
    public List<Seeker> getSeekerAll();

    @Select("select * from seeker where id = #{id}")
    public Seeker getSeekerById(Integer id);

    @Update("update seeker set  isForbidden = #{isForbidden}  where id = #{id} ")
    public int EditIsForbidden(Integer id,Integer isForbidden);

    @Select("select * from seeker where zone_id = #{id} and isForbidden = 0")
    public List<Seeker> getSeekerByZoneId(Integer id);

}
