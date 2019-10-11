package com.chunkit.wifi_monitor.service;

import com.chunkit.wifi_monitor.entity.Info;
import com.chunkit.wifi_monitor.entity.Msg;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @auther ChunKit
 * @date 2019/10/10-14:25
 */
public interface InfoService {

    public List<Info> getInfoBySeekerIdAndMinute(Integer s_id, HttpServletRequest request);

    public List<Info> getInfoBySeekerIdAndMac(Integer s_id , String mac);
}
