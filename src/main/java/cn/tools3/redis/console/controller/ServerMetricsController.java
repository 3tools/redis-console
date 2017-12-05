package cn.tools3.redis.console.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author :  blentle
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/5 0005
 * @description : monitor to supervise redis server
 * @since : 1.0
 */
@Controller
@RequestMapping("/metrics")
public class ServerMetricsController {

    private static final Logger logger = LoggerFactory.getLogger(ServerMetricsController.class);

    @RequestMapping("/serverInfo")
    public ModelAndView serverInfo() {

        return new ModelAndView("metrics/workspace/vSys");
    }
}
