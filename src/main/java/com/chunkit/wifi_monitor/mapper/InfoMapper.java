package com.chunkit.wifi_monitor.mapper;

import com.chunkit.wifi_monitor.entity.Info;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @auther ChunKit
 * @date 2019/9/18-23:06
 */

public interface InfoMapper {


    @Select("select * from info where s_id = #{id}")
    public List<Info> getInfoBySeekerId(Integer id);

    @Select("select * from info where s_id =#{id} and mac = #{mac}")
    public List<Info> getInfoBySeekerIdAndMac(Integer id,String mac);
}
