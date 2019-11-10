package com.chunkit.wifi_monitor;


import com.chunkit.wifi_monitor.entity.Info;
import com.chunkit.wifi_monitor.entity.Path;
import com.chunkit.wifi_monitor.entity.Seeker;
import com.chunkit.wifi_monitor.mapper.InfoMapper;
import com.chunkit.wifi_monitor.mapper.PathMapper;
import com.chunkit.wifi_monitor.mapper.SeekerMapper;
import com.chunkit.wifi_monitor.parser.Parser;
import com.chunkit.wifi_monitor.parser.ParserImpl;
import com.chunkit.wifi_monitor.parser.PathTracer;
import com.chunkit.wifi_monitor.parser.PathTracerImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//CommandLineRunner:服务启动执行
@Component
public class Monitor implements CommandLineRunner {

    int port = 8090;
    DatagramSocket ds;
    DatagramPacket dp;
    byte[] buf = null;
    String strReceive;
    //s e p e r a t o r
    Map<String, Object> parseResult = null;
    int items;
    int i = 1;
    Parser parser = new ParserImpl();
    @Resource
    InfoMapper infoMapper;
    @Resource
    PathMapper pathMapper;
    @Resource
    SeekerMapper seekerMapper;
    //路径跟踪
    PathTracer tracer = new PathTracerImpl();
    //路径跟踪返回的数据进行存储
    List<Path> paths = new ArrayList<Path>();

    @Override
    public void run(String... args) throws Exception {
        try {

            //发送
            ds = new DatagramSocket(port);
            System.out.println("monitor is online, waiting for data...");
//				test to send something
            String strSend = "true";
//				InetAddress addr=InetAddress.getByName("127.0.0.1");
            InetAddress addr = InetAddress.getByName("192.168.1.100");
            DatagramPacket send = new DatagramPacket(strSend.getBytes(), strSend.length(), addr, 8080);
            ds.send(send);

            //接收数据
            while (true) {

                buf = new byte[1024];
                dp = new DatagramPacket(buf, buf.length);
                ds.receive(dp);
//						System.out.println("from client:");
                strReceive = new String(dp.getData(), "gb2312");
                strReceive = strReceive.trim();
                //出现;;
                System.out.println("receive data: " + strReceive);
                if (strReceive.indexOf("？") != -1 || strReceive.indexOf("?") != -1) {
                    System.out.println("存在问号?");
                    dp.setLength(1024);
                    continue;
                }
                if (strReceive != null) {
                    strReceive = strReceive.replaceAll(";;", ";");
                    this.receive(strReceive);
                    System.out.println("执行第" + (i++) + "次 receive();");
                }

                //					String strReceive=new String(dp.getData(),0,dp.getLength())+" from "+dp.getAddress().getHostAddress()+":"+dp.getPort();
//						System.out.println(strReceive);

//						String strSend="client respond";
//						DatagramPacket send=new DatagramPacket(strSend.getBytes(), strSend.length(), dp.getAddress(),8080);
//						ds.send(send);

//						dp.setLength(1024);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ds.close();
            System.out.println("退出while循环.................");
        }
        System.out.println("退出while循环.................");
    }

    /**
     * @param strReceive
     */
    public void receive(String strReceive) {
        //parse

        //过滤数据 问号？ 00开头
        if (strReceive != "" || strReceive.indexOf("?") != -1) {
            this.parseResult = parser.parse(strReceive, ",");
        }

        //save
        if (parseResult != null) {
            try {
                Seeker seeker = (Seeker) parseResult.get("seeker");
                List<Info> infos = (List<Info>) parseResult.get("infos");
                //获取seeker的实际地址
                Seeker realSeeker = seekerMapper.getSeekerById(seeker.getId());

                if (infos.size() > 0) {
                    //路径跟踪并存储
                    paths = tracer.trace(infos, realSeeker);
                    if (paths != null)
                        pathMapper.insertPaths(paths);
                    infoMapper.insertSeeker(seeker.getId(), seeker.getType(), seeker.getX(), seeker.getY());
                    infoMapper.insertInfos(infos);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("message wrong:" + strReceive);
        }
    }
}
