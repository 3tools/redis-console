package cn.tools3.redis.console.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/5 0005
 * @description :
 * @since : 1.0
 */
@Controller
@RequestMapping("/metrics")
public class RedisMetricsController {

    private static final Logger logger = LoggerFactory.getLogger(ServerMetricsController.class);

    @RequestMapping("/redisInfo")
    public ModelAndView listRedisServer() {
        //todo:
        return null;
    }
}
