package com.chmorn;

import com.chmorn.schedule.SignSchedule;
import com.chmorn.utils.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenxu
 * @version 1.0
 * @description 启动类
 * @date 2021/10/28
 **/
@SpringBootApplication
public class PtSignToolApplication {
    private static Logger logger = LoggerFactory.getLogger(PtSignToolApplication.class);

    public static void main(String[] args) {
        logger.info("启动开始......");
        SpringApplication.run(PtSignToolApplication.class,args);
        logger.info("启动完成......");

        //直接签到
        //SignSchedule sign = (SignSchedule) SpringUtil.getBean("signSchedule");
        //sign.oneSign();
    }

}
