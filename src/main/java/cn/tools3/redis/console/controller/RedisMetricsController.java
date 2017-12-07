package cn.tools3.redis.console.controller;

import cn.tools3.redis.console.dto.GenericInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/5 0005
 * @description :
 * @since : 1.0
 */
@Controller
@RequestMapping("/redis/metrics")
public class RedisMetricsController {

    private static final Logger logger = LoggerFactory.getLogger(ServerMetricsController.class);

    @RequestMapping("/info")
    public String listRedisServer() {
        return "metrics/redis/vRedis";
    }

    @RequestMapping("/api/servers")
    @ResponseBody
    public Map<String,List<String>> serverList() {
        List<String> list = Lists.newArrayList();
        list.add("192.168.10.110:6379");
        Map<String,List<String>> map = Maps.newHashMap();
        map.put("servers",list);
        return map;
    }

    @RequestMapping("/api/info")
    @ResponseBody
    public GenericInfo baseInfo() {
        GenericInfo info = new GenericInfo();
        info.setUsedMem(12345);
        info.setTotalClients(23);
        info.setTotalCmdProcessed(10);
        info.setTotalKeys(3006);
        info.setUptime(23698);
        return info;
    }

    @RequestMapping("/api/memory")
    @ResponseBody
    public String memoryInfo(String server,Date from , Date to) {
        return "[\n" +
                "            {\n" +
                "                \"datetime\": {\n" +
                "                    \"year\": 2017,\n" +
                "                    \"month\": 12,\n" +
                "                    \"day\": 07,\n" +
                "                    \"hour\": 18,\n" +
                "                    \"minute\": 01,\n" +
                "                    \"seconds\": 23\n" +
                "                },\n" +
                "                \"Max\": 1024 * 1024,\n" +
                "                \"Current\": 512 * 512\n" +
                "            }, {\n" +
                "                \"datetime\": {\n" +
                "                    \"year\": 2017,\n" +
                "                    \"month\": 12,\n" +
                "                    \"day\": 07,\n" +
                "                    \"hour\": 18,\n" +
                "                    \"minute\": 01,\n" +
                "                    \"seconds\": 24\n" +
                "                },\n" +
                "                \"Max\": 1024 * 1024 * 5,\n" +
                "                \"Current\": 512 * 512 * 2\n" +
                "            },\n" +
                "            {\n" +
                "                \"datetime\": {\n" +
                "                    \"year\": 2017,\n" +
                "                    \"month\": 12,\n" +
                "                    \"day\": 07,\n" +
                "                    \"hour\": 18,\n" +
                "                    \"minute\": 01,\n" +
                "                    \"seconds\": 25\n" +
                "                },\n" +
                "                \"Max\": 1024 * 1024 * 5,\n" +
                "                \"Current\": 512 * 1024 * 2\n" +
                "            },\n" +
                "        ]";
    }
}
