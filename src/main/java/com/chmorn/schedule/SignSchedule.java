package com.chmorn.schedule;

import com.chmorn.config.GlobalConfig;
import com.chmorn.utils.SignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * @author chenxu
 * @version 1.0
 * @description 定时任务签到
 * @date 2021/10/28
 **/
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SignSchedule {

    private static Logger logger = LoggerFactory.getLogger(SignSchedule.class);

    //休眠时间，一个站签到成功，2秒后再签到另外一个
    private static final int SLEEPTIME = 2;

    @Autowired
    private GlobalConfig globalConfig;

    //每天凌晨1点执行一次：
    @Scheduled(cron = "0 0 1 * * ?")
    //每隔24小时执行一次
    //@Scheduled(cron = "0 0 */24 * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void sign() {
        oneSign();
    }

    public void oneSign(){
        try {
            logger.info("执行定时任务时间: " + LocalDateTime.now());
            SignUtil signUtil = new SignUtil(globalConfig);
            //ttg
            signUtil.signTtg();
            Thread.sleep(1000 * SLEEPTIME);
            //hdc
            signUtil.signHdc();
            Thread.sleep(1000 * SLEEPTIME);
            //time
            signUtil.signTime();
            Thread.sleep(1000 * SLEEPTIME);
            //hares
            signUtil.signHares();
            Thread.sleep(1000 * SLEEPTIME);
            //lemon
            signUtil.signLemon();
            //
            Thread.sleep(1000 * SLEEPTIME);
            signUtil = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("当天签到结束: " + LocalDateTime.now());

        logger.info("---------我是可爱的分隔线------------------------------------" );
    }
}
